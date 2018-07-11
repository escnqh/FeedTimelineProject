package com.meitu.qihangni.feedtimelineproject.imageLoader;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

/**
 * @author nqh 2018/7/11
 */
class RequestResult {
    BitmapDrawable bitmapDrawable;
    ImageView imageView;

    RequestResult(BitmapDrawable bitmapDrawable, ImageView imageView) {
        this.bitmapDrawable = bitmapDrawable;
        this.imageView = imageView;
    }
}
