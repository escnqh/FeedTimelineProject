package com.meitu.qihangni.feedtimelineproject.networktool;

/**
 * 响应结果实体
 *
 * @author nqh 2018/7/11
 */
public class Response {

    private final int mCode;
    private final String mMessage;
    private final String mMethod;
    private final String mContentType;
    private final int mContentLength;
    private final String mBody;

    public Response(Builder builder) {
        this.mCode = builder.code;
        this.mMessage = builder.message;
        this.mMethod = builder.method;
        this.mContentType = builder.contentType;
        this.mContentLength = builder.contentLength;
        this.mBody = builder.body;
    }

    public int getCode() {
        return mCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public String getMethod() {
        return mMethod;
    }

    public String getContentType() {
        return mContentType;
    }

    public int getContentLength() {
        return mContentLength;
    }

    public boolean isSuccessful() {
        return this.mCode >= 200 && this.mCode < 300;
    }

    public String getBody() {
        return mBody;
    }

    public static class Builder {
        private int code;
        private String message;
        private String method;
        private String contentType;
        private int contentLength;
        private String body;

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder contentLength(int contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }
}
