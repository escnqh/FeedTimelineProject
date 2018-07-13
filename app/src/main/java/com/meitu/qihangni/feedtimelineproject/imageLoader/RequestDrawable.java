package com.meitu.qihangni.feedtimelineproject.imageLoader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import java.lang.ref.WeakReference;

/**
 * @author nqh 2018/7/12
 */
public class RequestDrawable extends BitmapDrawable {
    private WeakReference<RequestRunnable> mRunnableRef;

    RequestDrawable(Resources res, Bitmap bitmap, RequestRunnable runnable) {
        super(res, bitmap);
        mRunnableRef = new WeakReference<>(runnable);
    }

    RequestRunnable getRunnable() {
        return mRunnableRef.get();
    }
}
