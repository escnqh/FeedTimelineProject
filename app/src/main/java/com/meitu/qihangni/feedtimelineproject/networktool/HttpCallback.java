package com.meitu.qihangni.feedtimelineproject.networktool;

/**
 * 对外的定义响应结果的接口
 *
 * @author nqh 2018/7/11
 */
public interface HttpCallback {
    void onComplete(Response response);

    void onError(Throwable e);
}
