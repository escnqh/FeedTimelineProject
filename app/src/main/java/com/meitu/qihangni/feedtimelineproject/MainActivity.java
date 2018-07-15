package com.meitu.qihangni.feedtimelineproject;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.meitu.qihangni.feedtimelineproject.jsondecoder.JsonDecoder;
import com.meitu.qihangni.feedtimelineproject.networktool.HttpCallback;
import com.meitu.qihangni.feedtimelineproject.networktool.Request;
import com.meitu.qihangni.feedtimelineproject.networktool.Response;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();
    private static final int GETRESULT = 0;
    private ListView mListView;
    private Context mContext;
    List<PageContent> mPageContentList = new ArrayList<>();
    public Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == GETRESULT) {
                mListView.setAdapter(new ListViewAdapter(mContext, mPageContentList));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.listview);
        mContext = this;
        Request.Builder builder = new Request.Builder()
                .url("http://preapi.meipai.com/hot/feed_timeline.json?page=2");
        Request.newRequest(builder, new HttpCallback() {
            @Override
            public void onComplete(Response response) {
                if (response.getContent() instanceof String) {
                    try {
                        String strJson = (String) response.getContent();
                        JSONArray jsonArray = new JSONArray(strJson);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            mPageContentList.add(JsonDecoder.parseJsonToObject(PageContent.class, jsonArray.getJSONObject(i)));
                        }
                        mMainHandler.obtainMessage(GETRESULT).sendToTarget();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError:" + e.getMessage());
            }
        }).executeAsync();
    }
}
