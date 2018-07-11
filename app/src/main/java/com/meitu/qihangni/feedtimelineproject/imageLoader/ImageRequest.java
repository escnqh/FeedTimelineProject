package com.meitu.qihangni.feedtimelineproject.imageLoader;

import android.content.Context;

/**
 * @author nqh 2018/7/11
 */
class ImageRequest {
    private static final String TAG = "ImageRequest";
    private static final int IO_BUFFER_SIZE = 8 * 1024;
    private ImageCache mImageCache = null;
    private boolean mIsDiskLruCacheCreated = false;
    public ImageRequest(Context context) {
        mImageCache  = new ImageCache(context);
        mIsDiskLruCacheCreated = mImageCache.isDiskLruCacheCreated();

    }
}
