package com.meitu.qihangni.feedtimelineproject.networktool;

import android.util.Log;

import java.net.URLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author nqh 2018/7/18
 */
public class HttpClient {
    private final static String TAG = HttpClient.class.getName();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final long KEEP_ALIVE = 10L;
    private static volatile boolean isInitContentHandlerFactory = false;
    private static HttpCallback mHttpCallback;
    private static Request mRequest;

    private static class GetHttpClientInstance {
        private static final HttpClient instance = new HttpClient();
    }

    public static HttpClient newRequest(Request request) {
        return newRequest(request, null);
    }

    public static HttpClient newRequest(Request request, HttpCallback httpCallback) {
        //这里做只有一次的ContentHandlerFactory实现类替换
        if (!isInitContentHandlerFactory) {
            synchronized (HttpClient.class) {
                if (!isInitContentHandlerFactory) {
                    isInitContentHandlerFactory = true;
                    URLConnection.setContentHandlerFactory(new ContentHandlerFactoryImpl());
                    Log.i(TAG, "    ContentFactoryInit!");
                }
            }
        }
        mRequest = request;
        mHttpCallback = httpCallback;
        return GetHttpClientInstance.instance;
    }

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy()
            );

    public void execute() {
        THREAD_POOL_EXECUTOR.execute(new RequestRunnable(mRequest, mHttpCallback));
    }
}
