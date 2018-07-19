package com.meitu.qihangni.feedtimelineproject.networktool;

import java.util.ArrayList;
import java.util.List;

/**
 * 请求实体
 *
 * @author nqh 2018/7/18
 */
public class Request {
    protected final String mUrl;
    protected final List<String> mParams;
    protected final List<String> mHeaders;
    protected final String mString;
    protected final HttpMethod mMethod;

    private Request(Builder builder) {
        this.mUrl = builder.url;
        this.mParams = builder.params;
        this.mHeaders = builder.headers;
        this.mMethod = builder.method;
        this.mString = builder.string;
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
