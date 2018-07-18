package com.meitu.qihangni.feedtimelineproject.bean;

/**
 * @author nqh 2018/7/18
 */
public class FollowMediaInfoBean {
    /**
     * follow_type : 1
     * current_media_id : 430232210
     * follow_media_id : 430232210
     * follow_media_uid : 1025716744
     * follow_media_screen_name : jack-不要动我
     * follow_start_time : 0
     * follow_end_time : 0
     * topic : ♫♬美拍430232210视频跟拍
     * topic_id : 6390445144672078481
     */

    private int follow_type;
    private int current_media_id;
    private int follow_media_id;
    private int follow_media_uid;
    private String follow_media_screen_name;
    private int follow_start_time;
    private int follow_end_time;
    private String topic;
    private String topic_id;

    public int getFollow_type() {
        return follow_type;
    }

    public void setFollow_type(int follow_type) {
        this.follow_type = follow_type;
    }

    public int getCurrent_media_id() {
        return current_media_id;
    }

    public void setCurrent_media_id(int current_media_id) {
        this.current_media_id = current_media_id;
    }

    public int getFollow_media_id() {
        return follow_media_id;
    }

    public void setFollow_media_id(int follow_media_id) {
        this.follow_media_id = follow_media_id;
    }

    public int getFollow_media_uid() {
        return follow_media_uid;
    }

    public void setFollow_media_uid(int follow_media_uid) {
        this.follow_media_uid = follow_media_uid;
    }

    public String getFollow_media_screen_name() {
        return follow_media_screen_name;
    }

    public void setFollow_media_screen_name(String follow_media_screen_name) {
        this.follow_media_screen_name = follow_media_screen_name;
    }

    public int getFollow_start_time() {
        return follow_start_time;
    }

    public void setFollow_start_time(int follow_start_time) {
        this.follow_start_time = follow_start_time;
    }

    public int getFollow_end_time() {
        return follow_end_time;
    }

    public void setFollow_end_time(int follow_end_time) {
        this.follow_end_time = follow_end_time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }
}
