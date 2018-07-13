package com.meitu.qihangni.feedtimelineproject.bitmapLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import com.meitu.qihangni.feedtimelineproject.networkTool.HttpCallback;
import com.meitu.qihangni.feedtimelineproject.networkTool.Request;
import com.meitu.qihangni.feedtimelineproject.networkTool.Response;

import java.lang.ref.WeakReference;

/**
 * @author nqh 2018/7/12
 */
public class Decoder implements Runnable {
    private final String TAG = this.getClass().getName();
    private WeakReference<ImageView> mImageViewRef;
    private String mUrl;

    Decoder(ImageView imageView, String url) {
        this.mImageViewRef = new WeakReference<>(imageView);
        this.mUrl = url;
    }


    @Override
    public void run() {
        Request.Builder builder = new Request.Builder().url(mUrl);
        Request.newRequest(builder, new HttpCallback() {
            @Override
            public void onComplete(Response response) {

            }

            @Override
            public void onError(Throwable e) {

            }
        }).executeAsync();
    }


}
