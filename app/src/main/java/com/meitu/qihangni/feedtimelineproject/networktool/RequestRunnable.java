package com.meitu.qihangni.feedtimelineproject.networktool;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nqh 2018/7/18
 */
public class RequestRunnable implements Runnable {
    private final String TAG = this.getClass().getName();

    private final static int CONNECT_TIME_OUT_MILLISECOND = 10000;
    private final static int READ_TIME_OUT_MILLISECOND = 20000;
    private String mUrl;
    private List<String> mParams;
    private List<String> mHeaders;
    private String mString;
    private HttpMethod mMethod;

    private RequestRunnable(Builder builder){
        this.mUrl = builder.url;
        this.mParams = builder.params;
        this.mHeaders = builder.headers;
        this.mMethod = builder.method;
        this.mString = builder.string;
    }

    @Override
    public void run() {

    }

    public static class Builder {
        private String url;
        private List<String> params = new ArrayList<>();
        private List<String> headers = new ArrayList<>();
        private HttpMethod method = HttpMethod.GET;
        private String string;

        public RequestRunnable.Builder url(String url) {
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("mUrl can not be null or empty");
            }
            this.url = url;
            return this;
        }

        public RequestRunnable.Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        public RequestRunnable.Builder params(String key, String value) {
            params.add(key);
            params.add(value);
            return this;
        }

        public RequestRunnable.Builder headers(String key, String values) {
            headers.add(key);
            headers.add(values);
            return this;
        }

        public RequestRunnable.Builder string(String string) {
            this.string = string;
            return this;
        }

        public RequestRunnable build() {
            return new RequestRunnable(this);
        }

    }
}
