package com.meitu.qihangni.feedtimelineproject.imageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nqh 2018/7/11
 */
public class ImageLoader {
    private static final String TAG = "ImageLoader";
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final long KEEP_ALIVE = 10L;
    private static volatile ImageLoader mImageLoader = null;
    private ImageRequest mImageRequest = null;
    public static final int MESSAGE_POST_RESULT = 1;
    private final Context mContext;

    public Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MESSAGE_POST_RESULT) {
                RequestResult result = (RequestResult) msg.obj;
                ImageView imageView = result.imageView;
                imageView.setImageDrawable(result.bitmapDrawable);
            }
        }
    };

    private ImageLoader(Context context) {
        mContext = context;
        mImageRequest = new ImageRequest(context);
    }

    public static ImageLoader getInstance(Context context) {
        Context internalContext = context.getApplicationContext();
        if (mImageLoader == null) {
            synchronized (ImageLoader.class) {
                if (mImageLoader == null) {
                    mImageLoader = new ImageLoader(internalContext);
                }
            }
        }
        return mImageLoader;
    }

    public void into(String url, ImageView imageView) {
        into(url, imageView, 0, 0);
    }

    public void into(final String url, final ImageView imageView, final int reqWidth, final int reqHeight) {

        Bitmap bitmap = mImageRequest.requestFromMemoryCache(url);
        if (bitmap != null) {
            Log.i(TAG, "request: from lruCache");
            setBitmap(imageView, bitmap);
            return;
        }
        if (cancelRequestRunnable(url, imageView)) {
            RequestRunnable requestRunnable = new RequestRunnable(this, imageView, url, reqWidth, reqHeight);
            RequestDrawable requestDrawable = new RequestDrawable(getContext().getResources(), null, requestRunnable);
            imageView.setImageDrawable(requestDrawable);
            THREAD_POOL_EXECUTOR.execute(requestRunnable);
        }
    }

    private void setBitmap(ImageView imageView, Bitmap bitmap) {
        BitmapDrawable drawable = new BitmapDrawable(mContext.getResources(), bitmap);
        imageView.setImageDrawable(drawable);
    }

    Bitmap loadBitmap(String url, int reqWidth, int reqHeight) {
        Bitmap bitmap = mImageRequest.requestFromDiskCache(url, reqWidth, reqHeight);
        if (bitmap != null) {
            Log.i(TAG, "request: from diskLruCache");
            return bitmap;
        }
        bitmap = mImageRequest.requestFromHttp(url, reqWidth, reqHeight);
        if (bitmap != null) {
            Log.i(TAG, "request: from http");
            return bitmap;
        }
        return null;
    }

    public RequestRunnable getRequestRunnable(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                if (drawable instanceof RequestDrawable) {
                    Log.i(TAG, "getRequestRunnable: drawable instanceOf requestDrawable");
                    RequestDrawable requestDrawable = (RequestDrawable) drawable;
                    return requestDrawable.getRunnable();
                } else {
                    Log.i(TAG, "getRequestRunnable: drawable not instanceOf requestDrawable");
                }
            } else {
                Log.i(TAG, "getRequestRunnable: drawable is null");
            }

        }
        return null;
    }

    /**
     * 当url重复时
     *
     * @param url
     * @param imageView
     * @return
     */
    private boolean cancelRequestRunnable(String url, ImageView imageView) {
        RequestRunnable previous = getRequestRunnable(imageView);
        if (previous != null) {
            String imageUrl = previous.mUrl;
            if (imageUrl == null || !imageUrl.equals(url)) {
                previous.setIsCanceled(true);
                boolean remove = THREAD_POOL_EXECUTOR.remove(previous);
                Log.i(TAG, "cancelRequestRunnable: remove previous " + remove);
            } else {
                Log.i(TAG, "cancelRequestRunnable: didn't remove");
                //当前imageView已经有drawable
                return false;
            }
        }

        if (previous == null) {
            Log.d(TAG, "cancelRequestRunnable: runnable is null, cancel terminated");
        } else {
            Log.d(TAG, "cancelRequestRunnable: cancel request success");
        }
        return true;
    }

    public Context getContext() {
        return mContext;
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
