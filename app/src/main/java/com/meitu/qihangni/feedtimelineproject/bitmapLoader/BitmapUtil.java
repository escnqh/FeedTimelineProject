package com.meitu.qihangni.feedtimelineproject.bitmapLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author nqh 2018/7/12
 */
public class BitmapUtil {
    /**
     * HttpURLConnection下载图片并转化为bitmap
     * @param imgUrl
     * @return
     */
    public static Bitmap getBitmap(String imgUrl) {
        try {
            //生成url
            URL url = new URL(imgUrl);
            //建立连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置超时 5s
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(4000);
            connection.setDoInput(true);
            //设置请求方法
            connection.setRequestMethod("GET");
            //连接成功
            connection.connect();
            if (connection.getResponseCode()==200){
                //获取输入流
                InputStream in=connection.getInputStream();
                //将流转化为bitmap
                Bitmap bitmap= BitmapFactory.decodeStream(in);
                return bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * imageview加载图片
     * @param imageView
     * @param bitmap
     */
    public static void setImageView(ImageView imageView, Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

}
