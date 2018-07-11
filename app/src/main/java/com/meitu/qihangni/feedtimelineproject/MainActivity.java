package com.meitu.qihangni.feedtimelineproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.meitu.qihangni.feedtimelineproject.jsontool.JsonLoader;
import com.meitu.qihangni.feedtimelineproject.jsontool.PageContent;
import com.meitu.qihangni.feedtimelineproject.networktool.HttpCallback;
import com.meitu.qihangni.feedtimelineproject.networktool.Request;
import com.meitu.qihangni.feedtimelineproject.networktool.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Request.Builder builder = new Request.Builder()
                .url("http://preapi.meipai.com/hot/feed_timeline.json?page=2");
        Request.newRequest(builder, new HttpCallback() {
            @Override
            public void onComplete(Response response) {
                Log.i(TAG, "onComplete/response:" + response.getBody());
                List<PageContent> pageContentList = new ArrayList<>();
                try {
                    JSONArray jsonArray=new JSONArray(response.getBody());
                    pageContentList.add(JsonLoader.parseJsonToObject(PageContent.class,jsonArray.getJSONObject(0)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError:" + e.getMessage());
            }
        }).executeAsync();
    }
}
