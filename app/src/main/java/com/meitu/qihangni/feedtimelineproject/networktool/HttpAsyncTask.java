package com.meitu.qihangni.feedtimelineproject.networktool;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * 用asynctask实现异步请求
 *
 * @author nqh 2018/7/11
 */
public class HttpAsyncTask extends AsyncTask<Void, Void, Response> {

    private final Request mRequest;
    private final HttpURLConnection mConnection;
    private final HttpCallback mHttpCallback;
    private final String TAG = this.getClass().getName();

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
        Log.i(TAG, response.toString());
        super.onPostExecute(response);
        if (mHttpCallback != null) {
            mHttpCallback.onComplete(response);
        }
    }
}
