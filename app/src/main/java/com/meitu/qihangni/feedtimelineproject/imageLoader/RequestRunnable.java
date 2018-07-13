package com.meitu.qihangni.feedtimelineproject.imageLoader;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * @author nqh 2018/7/12
 */
public class RequestRunnable implements Runnable {
    private static final String TAG = "RequestRunnable";
    private ImageLoader mImageLoader;
    private WeakReference<ImageView> mImageViewRef;
    String mUrl;
    private int mReqWidth;
    private int mReqHeight;
    private boolean mIsCanceled = false;

    RequestRunnable(ImageLoader mImageLoader, ImageView imageView, String url, int reqWidth, int reqHeight) {
        this.mImageLoader = mImageLoader;
        this.mImageViewRef = new WeakReference<>(imageView);
        this.mUrl = url;
        this.mReqWidth = reqWidth;
        this.mReqHeight = reqHeight;
    }

    @Override
    public void run() {
        ImageView imageView = getAttachImageView();
        if (imageView != null) {
            Bitmap bitmap = mImageLoader.loadBitmap(mUrl, mReqWidth, mReqHeight);
            Log.i(TAG, "run: " + (bitmap == null ? "null" : "not null"));
            Log.i(TAG, "run: " + mIsCanceled);
            if (bitmap != null && !mIsCanceled) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(mImageLoader.getContext().getResources(),
                        bitmap);
                RequestResult result = new RequestResult(bitmapDrawable, imageView);
                mImageLoader.mMainHandler
                        .obtainMessage(ImageLoader.MESSAGE_POST_RESULT, result).sendToTarget();
            }
        }
    }

    void setIsCanceled(boolean mIsCanceled) {
        this.mIsCanceled = mIsCanceled;
    }


    private ImageView getAttachImageView() {
        ImageView imageView = mImageViewRef.get();
        RequestRunnable previous = mImageLoader.getRequestRunnable(imageView);
        if (this == previous) {
            Log.d(TAG, "getAttachImageView: runnable is equals");
            return imageView;
        }
        Log.d(TAG, "getAttachImageView: runnable is not equals");
        return null;
    }
}
