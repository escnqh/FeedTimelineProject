package com.meitu.qihangni.feedtimelineproject.bean;

/**
 * @author nqh 2018/7/11
 */
public class PageContentBean {
    /**
     * recommend_caption : #甜甜的#
     * recommend_cover_pic : http://mppic-test.zone1.meitudata.com/5ad04c124ffc45322.jpg!thumb320
     * recommend_cover_pic_size : 540*954
     * media : {"id":430232210,"caption":"#甜甜的#","weibo_share_caption":"#甜甜的#. click to view>>","facebook_share_caption":"","weixin_share_caption":"Sharing jack-不要动我\u2019s videos","weixin_friendfeed_share_caption":"#甜甜的#","qzone_share_caption":"#甜甜的#","qq_share_caption":"#甜甜的#","instagram_share_caption":"Sharing jack-不要动我\u2019s video \u201c#甜甜的#\u201d, come and take a look!","weixin_share_sub_caption":"#甜甜的#","weixin_friendfeed_share_sub_caption":"","qzone_share_sub_caption":"","qq_share_sub_caption":"","geo":null,"video":"http://mpvideo-test.zone1.meitudata.com/5ad04c124fbbc4998.mp4","url":"http://www.meipai.com/media/430232210?client_id=1089857299?utm_source=meipai_share?utm_term=meipai_ios?utm_content=test?viewCount=1?shareCount=1","cover_pic":"http://mppic-test.zone1.meitudata.com/5ad04c124ffc45322.jpg!thumb320","pic_size":"540*954","category":3,"time":5,"is_long":false,"show_controls":false,"created_at":"1523600410","comments_count":19,"likes_count":140,"reposts_count":0,"is_popular":false,"user":{"id":1025716744,"screen_name":"jack-不要动我","country":1100000,"province":0,"city":0,"avatar":"http://mppic-test.zone1.meitudata.com/599698ae9a256787.jpg","gender":"f","birthday":"2016-10-28","age":1,"constellation":"Scorpio","verified":true,"followers_count":197,"friends_count":172,"reposts_count":83,"videos_count":1358,"real_videos_count":1022,"photos_count":336,"locked_videos_count":53,"real_locked_videos_count":53,"locked_photos_count":0,"be_liked_count":664,"url":"http://www.meipai.com/user/1025716744?client_id=1089857299","created_at":1465192611,"has_password":false,"status":"5","is_funy_core_user":false,"funy_core_user_created_at":0,"last_publish_time":0,"level":70,"show_pendant":true,"level_hide_coins":false,"level_hide_beans":false,"has_assoc_phone":false,"is_safe_white_list":false},"feed_id":6543813935699907218,"locked":false,"type":5,"caption_url_params":[],"privacy_config":{"allow_save_medias":0,"forbid_stranger_comment":0,"forbid_comment":0,"forbid_repost":0},"has_watermark":0,"refuse_gift":false,"new_music":null,"follow_media_info":{"follow_type":1,"current_media_id":430232210,"follow_media_id":430232210,"follow_media_uid":1025716744,"follow_media_screen_name":"jack-不要动我","follow_start_time":0,"follow_end_time":0,"topic":"♫♬美拍430232210视频跟拍","topic_id":"6390445144672078481"},"convert_cover_pic":null,"ar_magic_info":null,"aside_info":null,"convert_pic_size":null,"cover_pic_resize":null,"ad_level":"N","first_frame_pic":null,"first_frame_pic_size":null,"is_safe":1,"is_safe2":0,"cover_title":"","dangerous_action":false,"display_source":1}
     * type : media
     * recommend_cover_pic_color : #4B7AFA
     * recommend_cover_dynamic_pic :
     */

    private String recommend_caption;
    private String recommend_cover_pic;
    private String recommend_cover_pic_size;
    private MediaBean media;
    private String type;
    private String recommend_cover_pic_color;
    private String recommend_cover_dynamic_pic;

    public String getRecommend_caption() {
        return recommend_caption;
    }

    public void setRecommend_caption(String recommend_caption) {
        this.recommend_caption = recommend_caption;
    }

    public String getRecommend_cover_pic() {
        return recommend_cover_pic;
    }

    public void setRecommend_cover_pic(String recommend_cover_pic) {
        this.recommend_cover_pic = recommend_cover_pic;
    }

    public String getRecommend_cover_pic_size() {
        return recommend_cover_pic_size;
    }

    public void setRecommend_cover_pic_size(String recommend_cover_pic_size) {
        this.recommend_cover_pic_size = recommend_cover_pic_size;
    }

    public MediaBean getMedia() {
        return media;
    }

    public void setMedia(MediaBean media) {
        this.media = media;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecommend_cover_pic_color() {
        return recommend_cover_pic_color;
    }

    public void setRecommend_cover_pic_color(String recommend_cover_pic_color) {
        this.recommend_cover_pic_color = recommend_cover_pic_color;
    }

    public String getRecommend_cover_dynamic_pic() {
        return recommend_cover_dynamic_pic;
    }

    public void setRecommend_cover_dynamic_pic(String recommend_cover_dynamic_pic) {
        this.recommend_cover_dynamic_pic = recommend_cover_dynamic_pic;
    }
}
