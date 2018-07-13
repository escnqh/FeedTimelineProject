package com.meitu.qihangni.feedtimelineproject.bitmapLoader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nqh 2018/7/12
 */
public class ImageLoader {
    private final String TAG = this.getClass().getName();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final long KEEP_ALIVE = 10L;
    private static volatile ImageLoader mImageLoader = null;
    public static final int MESSAGE_POST_RESULT = 1;
    private final Context mContext;

    public Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MESSAGE_POST_RESULT) {

            }
        }
    };

    private ImageLoader(Context context) {
        mContext = context;
    }

    public static ImageLoader getInstance(Context context) {
        Context internalContext = context.getApplicationContext();
        if (mImageLoader == null) {
            synchronized (com.meitu.qihangni.feedtimelineproject.imageLoader.ImageLoader.class) {
                if (mImageLoader == null) {
                    mImageLoader = new ImageLoader(internalContext);
                }
            }
        }
        return mImageLoader;
    }


    public void into(final String url, final ImageView imageView) {
        Decoder decoder = new Decoder(imageView, url);
        THREAD_POOL_EXECUTOR.execute(decoder);
    }


    private static final ThreadFactory mThreadFactory = new ThreadFactory() {
        private final AtomicInteger atomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "imageLoader: " + atomicInteger.getAndIncrement());
        }
    };

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR =
            new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE,
                    TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), mThreadFactory
            );
}
