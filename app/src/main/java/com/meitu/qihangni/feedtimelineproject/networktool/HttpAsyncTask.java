package com.meitu.qihangni.feedtimelineproject.networktool;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * 异步请求的实现
 *
 * @author nqh 2018/7/11
 */
public class HttpAsyncTask extends AsyncTask<Void, Void, Response> {

    private Request mRequest;
    private HttpURLConnection mConnection;
    private HttpCallback mHttpCallback;
    private Exception mException;

    public HttpAsyncTask(Request request, HttpURLConnection connection, HttpCallback httpCallback) {
        this.mConnection = connection;
        this.mRequest = request;
        this.mHttpCallback = httpCallback;
    }

    @Override
    protected Response doInBackground(Void... params) {
        if (mRequest != null) {
            try {
                return mRequest.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        if (response == null) {
            if (mHttpCallback != null) {
                if (mException != null) {
                    mHttpCallback.onError(mException);
                } else {
                    mHttpCallback.onError(new Exception("UnKnown Exception"));
                }
            }
        } else {
            if (mHttpCallback != null) {
                mHttpCallback.onComplete(response);
            }
        }
    }
}
