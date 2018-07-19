package com.meitu.qihangni.feedtimelineproject.networktool;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author nqh 2018/7/18
 */
public class RequestRunnable implements Runnable {
    private final String TAG = this.getClass().getName();
    private HttpCallback mHttpCallback;
    private final static int CONNECT_TIME_OUT_MILLISECOND = 10000;
    private final static int READ_TIME_OUT_MILLISECOND = 20000;
    private String mUrl;
    private List<String> mParams;
    private List<String> mHeaders;
    private String mString;
    private HttpMethod mMethod;
    private HttpURLConnection mConnection;

    RequestRunnable(Request request, HttpCallback httpCallback) {
        mHttpCallback = httpCallback;
        this.mUrl = request.mUrl;
        this.mParams = request.mParams;
        this.mHeaders = request.mHeaders;
        this.mMethod = request.mMethod;
        this.mString = request.mString;
    }

    @Override
    public void run() {
        try {
            if (mMethod == HttpMethod.POST) {
                post();
            } else if (mMethod == HttpMethod.GET) {
                get();
            }
            response(mConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get请求
     */
    private void get() throws IOException {
        URL requestUrl = new URL(getUrl(mUrl));
        if (mUrl.equals("http://7xog4m.com1.z0.glb.clouddn.com/5b3dced054e53i2vo69g5r7182.jpg!thumb320")) {
            Log.i(TAG, "here");
        }
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

    private void connectHeaders() {
        if (mHeaders != null && mHeaders.size() > 0) {
            for (int i = 0; i < mHeaders.size(); i += 2) {
                mConnection.setRequestProperty(mHeaders.get(i), mHeaders.get(i + 1));
            }
        }
    }

    private void response(HttpURLConnection connection) throws IOException {
        Response response = new Response.Builder()
                .code(connection.getResponseCode())
                .message(connection.getResponseMessage())
                .method(connection.getRequestMethod())
                .contentType(connection.getContentType())
                .contentLength(connection.getContentLength())
                .content(connection.getContent())
                .build();
        connection.disconnect();
        if (mHttpCallback != null) {
            mHttpCallback.onComplete(response);
        }
    }
}
