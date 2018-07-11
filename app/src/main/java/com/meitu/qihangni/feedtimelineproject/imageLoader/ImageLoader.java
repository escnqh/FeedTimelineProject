package com.meitu.qihangni.feedtimelineproject.imageLoader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;

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
}
