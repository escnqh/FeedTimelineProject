package com.meitu.qihangni.feedtimelineproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.meitu.qihangni.feedtimelineproject.jsonDecoder.JsonLoader;
import com.meitu.qihangni.feedtimelineproject.jsonDecoder.PageContent;
import com.meitu.qihangni.feedtimelineproject.networkTool.ContentHandlerFactoryImpl;
import com.meitu.qihangni.feedtimelineproject.networkTool.HttpCallback;
import com.meitu.qihangni.feedtimelineproject.networkTool.Request;
import com.meitu.qihangni.feedtimelineproject.networkTool.Response;

import org.json.JSONArray;
import org.json.JSONException;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();
    private static final int GETRESULT = 0;
    private ListView listView;
    private Context mContext;
    List<PageContent> mPageContentList = new ArrayList<>();
    Bitmap bitmap;
    public Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == GETRESULT) {
                listView.setAdapter(new ListViewAdapter(mContext, mPageContentList));
//                ImageView imageView = findViewById(R.id.image_test);
//                imageView.setImageBitmap(bitmap);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        mContext = this;


//        Request.Builder builder = new Request.Builder().url("http://mppic-test.zone1.meitudata.com/5b0d20818531c2965.jpg!thumb320");
//        Request.newRequest(builder, new HttpCallback() {
//            @Override
//            public void onComplete(Response response) {
//                if (response.getContent() instanceof Bitmap) {
//                    bitmap = (Bitmap) response.getContent();
//                    mMainHandler.obtainMessage(GETRESULT).sendToTarget();
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        }).executeAsync();
        URLConnection.setContentHandlerFactory(new ContentHandlerFactoryImpl());
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
                            mPageContentList.add(JsonLoader.parseJsonToObject(PageContent.class, jsonArray.getJSONObject(i)));
                        }
//                        mPageContentList.add(JsonLoader.parseJsonToObject(PageContent.class, jsonArray.getJSONObject(0)));
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
