package com.meitu.qihangni.feedtimelineproject.networktool;

import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ContentHandler;
import java.net.ContentHandlerFactory;
import java.net.URLConnection;
import java.util.Objects;

/**
 * 通过setContentHandlerFactory()方法设置重写getContent()，在拿到inputstream之后直接处理返回相应对象
 *
 * @author nqh 2018/7/13
 */
public class ContentHandlerFactoryImpl implements ContentHandlerFactory {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private final String TAG = this.getClass().getName();

    @Override
    public ContentHandler createContentHandler(String mimetype) {
        Log.i(TAG, "mimetype is :" + mimetype);
        if (null == mimetype) {
            return new ContentHandlerImpl(false);
        } else {
            return new ContentHandlerImpl(true);
        }
    }

    static class ContentHandlerImpl extends ContentHandler {

        private boolean transform = false;

        public ContentHandlerImpl(boolean transform) {
            this.transform = transform;
        }

        @Override
        public Object getContent(URLConnection connection) throws IOException {
            if (!transform) {
                return connection.getInputStream();
            } else {
                String encoding = connection.getHeaderField("Content-Type");
                if (Objects.requireNonNull(getType(encoding))[0].equals("application")) {
                    if (Objects.requireNonNull(getType(encoding))[1].equals("json")) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), DEFAULT_ENCODING));
                        String temp = null;
                        StringBuilder content = new StringBuilder();
                        while ((temp = reader.readLine()) != null) {
                            content.append(temp);
                        }
                        return content.toString();
                    }
                } else if (Objects.requireNonNull(getType(encoding))[0].equals("image")) {
                    return BitmapFactory.decodeStream(connection.getInputStream());
                } else {
                    //todo 拓展更多方法
                    return null;
                }
            }
            return null;
        }

        private String[] getType(String mimetype) {
            String[] headers = mimetype.split(";");
            if (headers.length >= 1) {
                String[] params = headers[0].split("/");
                return params;
            }
            return null;
        }
    }


}
