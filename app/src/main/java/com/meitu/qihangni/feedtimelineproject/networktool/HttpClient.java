package com.meitu.qihangni.feedtimelineproject.networktool;

import java.net.URLConnection;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nqh 2018/7/18
 */
public class HttpClient {
    private final String TAG = this.getClass().getName();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final long KEEP_ALIVE = 10L;
    private static volatile boolean isInitContentHandlerFactory = false;
    private static HttpCallback mHttpCallback;

    private static class GetHttpClientInstance {
        private static final HttpClient instance = new HttpClient();
    }

    public static HttpClient newRequest(RequestRunnable requestRunnable) {
        return newRequest(requestRunnable, null);
    }

    public static HttpClient newRequest(RequestRunnable requestRunnable, HttpCallback httpCallback) {
        //这里做只有一次的ContentHandlerFactory实现类替换
        if (!isInitContentHandlerFactory) {
            synchronized (HttpClient.class) {
                if (!isInitContentHandlerFactory) {
                    isInitContentHandlerFactory = true;
                    URLConnection.setContentHandlerFactory(new ContentHandlerFactoryImpl());
                }
            }
        }
        mHttpCallback = httpCallback;
        return GetHttpClientInstance.instance;
    }

    private static final ThreadFactory mThreadFactory = new ThreadFactory() {
        private final AtomicInteger atomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "httpclient: " + atomicInteger.getAndIncrement());
        }
    };

    public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), mThreadFactory
            );
}
