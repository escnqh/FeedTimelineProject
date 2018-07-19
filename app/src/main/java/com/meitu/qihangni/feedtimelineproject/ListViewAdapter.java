package com.meitu.qihangni.feedtimelineproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.meitu.qihangni.feedtimelineproject.bean.PageContentBean;
import com.meitu.qihangni.feedtimelineproject.networktool.HttpCallback;
import com.meitu.qihangni.feedtimelineproject.networktool.HttpClient;
import com.meitu.qihangni.feedtimelineproject.networktool.Request;
import com.meitu.qihangni.feedtimelineproject.networktool.Response;

import java.util.List;

/**
 * @author nqh 2018/7/13
 */
public class ListViewAdapter extends BaseAdapter {
    private final static String TAG = ListViewAdapter.class.getName();
    private final Context mContext;
    private static final int MESSAGE_POST_RESULT = 1;
    private final List<PageContentBean> mPageContentBeanList;
    public Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MESSAGE_POST_RESULT) {
                RequestObj requestObj = (RequestObj) msg.obj;
                ImageView imageView = requestObj.imageView;
                imageView.setImageBitmap(requestObj.bitmap);
            }
        }
    };

    public ListViewAdapter(Context context, List<PageContentBean> pageContentBeanList) {
        this.mContext = context;
        this.mPageContentBeanList = pageContentBeanList;
    }

    @Override
    public int getCount() {
        return mPageContentBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPageContentBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_itemview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mImageCover = convertView.findViewById(R.id.imgv_cover);
            viewHolder.mTvContent = convertView.findViewById(R.id.tv_content);
            viewHolder.mTvName = convertView.findViewById(R.id.tv_username);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTvName.setText(mPageContentBeanList.get(position).getMedia().getUser().getScreen_name());
        viewHolder.mTvContent.setText(mPageContentBeanList.get(position).getMedia().getQq_share_caption());
        final String imgUrl = mPageContentBeanList.get(position).getRecommend_cover_pic();
        Request request = new Request.Builder()
                .url(imgUrl)
                .build();
        HttpClient.newRequest(request, new HttpCallback() {
            @Override
            public void onComplete(Response response) {
                if (response.getContent() instanceof Bitmap) {
                    RequestObj requestObj = new RequestObj((Bitmap) response.getContent(), viewHolder.mImageCover);
                    mMainHandler.obtainMessage(MESSAGE_POST_RESULT, requestObj).sendToTarget();
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        }).execute();
        return convertView;
    }

    private static class ViewHolder {
        ImageView mImageCover;
        TextView mTvName;
        TextView mTvContent;
    }

    private class RequestObj {
        Bitmap bitmap;
        ImageView imageView;

        RequestObj(Bitmap bitmap, ImageView imageView) {
            this.bitmap = bitmap;
            this.imageView = imageView;
        }
    }


}
