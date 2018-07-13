package com.meitu.qihangni.feedtimelineproject.networkTool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装HttpUrlConnection方法的请求
 *
 * @author nqh 2018/7/11
 */
public class Request {
    private final String TAG = this.getClass().getName();

    //设置超时
    private final static int CONNECT_TIME_OUT_MILLISECOND = 10000;
    private final static int READ_TIME_OUT_MILLISECOND = 20000;

    private String mUrl;
    private List<String> mParams;
    private List<String> mHeaders;
    private String mString;
    private HttpMethod mMethod;

    private HttpURLConnection mConnection;
    private static HttpCallback mHttpCallback;

    private Request(Builder builder) {
        this.mUrl = builder.url;
        this.mParams = builder.params;
        this.mHeaders = builder.headers;
        this.mMethod = builder.method;
        this.mString = builder.string;
    }

    /**
     * 新建请求方式1
     *
     * @param builder
     * @return
     */
    public static Request newRequest(Builder builder) {
        return newRequest(builder, null);
    }


    /**
     * 新建请求方式2
     *
     * @param builder
     * @param httpCallback 返回接口
     * @return
     */
    public static Request newRequest(Builder builder, HttpCallback httpCallback) {
        mHttpCallback = httpCallback;
        return new Request(builder);
    }

    /**
     * 异步请求
     */
    public void executeAsync() {
        HttpAsyncTask asyncTask = new HttpAsyncTask(this, mConnection, mHttpCallback);
        asyncTask.execute();
    }

    /**
     * 同步请求
     */
    public Response execute() throws IOException {
        if (mMethod == HttpMethod.POST) {
            post();
        } else if (mMethod == HttpMethod.GET) {

            get();
        }
        return response(mConnection);
    }

    /**
     * get请求
     */
    private void get() throws IOException {
        Log.i(TAG, "   " + mUrl);
        URL requestUrl = new URL(getUrl(mUrl));
        mConnection = (HttpURLConnection) requestUrl.openConnection();
        mConnection.setRequestMethod(String.valueOf(mMethod));
        mConnection.setConnectTimeout(CONNECT_TIME_OUT_MILLISECOND);
        mConnection.setReadTimeout(READ_TIME_OUT_MILLISECOND);
        mConnection.setDoInput(true);
        mConnection.setUseCaches(false);
        connectHeaders();
        mConnection.connect();
    }

    /**
     * get请求拼接url
     */
    private String getUrl(String url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url).append("?");
        for (int i = 0; i < mParams.size(); i += 2) {
            sb.append(mParams.get(i));
            sb.append("=");
            sb.append(mParams.get(i + 1));
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * post请求
     */
    private void post() throws IOException {
        URL requestUrl = new URL(mUrl);
        mConnection = (HttpURLConnection) requestUrl.openConnection();
        mConnection.setRequestMethod(String.valueOf(mMethod));
        mConnection.setConnectTimeout(CONNECT_TIME_OUT_MILLISECOND);
        mConnection.setReadTimeout(READ_TIME_OUT_MILLISECOND);
        mConnection.setDoInput(true);
        mConnection.setDoOutput(true);
        mConnection.setUseCaches(false);
        connectHeaders();
        mConnection.connect();
        postBody();
    }

    /**
     * post请求上传数据
     */
    private void postBody() throws IOException {
        postForm();
        postString();
    }

    /**
     * 上传表单
     */
    private void postForm() throws IOException {
        if (mParams != null && mParams.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mParams.size(); i += 2) {
                sb.append(mParams.get(i));
                sb.append("=");
                sb.append(mParams.get(i + 1));
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
            mConnection.getOutputStream().write(sb.toString().getBytes("GBK"));
        }
    }

    /**
     * 上传字符串，如json字符串
     */
    private void postString() throws IOException {
        if (mString != null && !mString.isEmpty()) {
            mConnection.getOutputStream().write(mString.getBytes("GBK"));
        }
    }

    /**
     * 设置请求头
     */
    private void connectHeaders() {
        if (mHeaders != null && mHeaders.size() > 0) {
            for (int i = 0; i < mHeaders.size(); i += 2) {
                mConnection.setRequestProperty(mHeaders.get(i), mHeaders.get(i + 1));
            }
        }
    }

    /**
     * 获取响应结果
     */
    private Response response(HttpURLConnection connection) throws IOException {
        Response resp = new Response.Builder()
                .code(connection.getResponseCode())
                .message(connection.getResponseMessage())
                .method(connection.getRequestMethod())
                .contentType(connection.getContentType())
                .contentLength(connection.getContentLength())
                .content(connection.getContent())
                .build();
        connection.disconnect();
        return resp;
    }

    public static class Builder {

        private String url;
        private List<String> params = new ArrayList<>();
        private List<String> headers = new ArrayList<>();
        private HttpMethod method = HttpMethod.GET;
        private String string;

        public Builder url(String url) {
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("mUrl can not be null or empty");
            }
            this.url = url;
            return this;
        }

        public Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        public Builder params(String key, String value) {
            params.add(key);
            params.add(value);
            return this;
        }

        public Builder headers(String key, String values) {
            headers.add(key);
            headers.add(values);
            return this;
        }

        public Builder string(String string) {
            this.string = string;
            return this;
        }

        public Request build() {
            return new Request(this);
        }

    }
}
