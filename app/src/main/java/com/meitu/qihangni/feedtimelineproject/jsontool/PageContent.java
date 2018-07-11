package com.meitu.qihangni.feedtimelineproject.jsontool;

import java.util.List;

/**
 * @author nqh 2018/7/11
 */
public class PageContent {
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
    private Media media;
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

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
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

    public static class Media {
        /**
         * id : 430232210
         * caption : #甜甜的#
         * weibo_share_caption : #甜甜的#. click to view>>
         * facebook_share_caption :
         * weixin_share_caption : Sharing jack-不要动我’s videos
         * weixin_friendfeed_share_caption : #甜甜的#
         * qzone_share_caption : #甜甜的#
         * qq_share_caption : #甜甜的#
         * instagram_share_caption : Sharing jack-不要动我’s video “#甜甜的#”, come and take a look!
         * weixin_share_sub_caption : #甜甜的#
         * weixin_friendfeed_share_sub_caption :
         * qzone_share_sub_caption :
         * qq_share_sub_caption :
         * geo : null
         * video : http://mpvideo-test.zone1.meitudata.com/5ad04c124fbbc4998.mp4
         * url : http://www.meipai.com/media/430232210?client_id=1089857299?utm_source=meipai_share?utm_term=meipai_ios?utm_content=test?viewCount=1?shareCount=1
         * cover_pic : http://mppic-test.zone1.meitudata.com/5ad04c124ffc45322.jpg!thumb320
         * pic_size : 540*954
         * category : 3
         * time : 5
         * is_long : false
         * show_controls : false
         * created_at : 1523600410
         * comments_count : 19
         * likes_count : 140
         * reposts_count : 0
         * is_popular : false
         * user : {"id":1025716744,"screen_name":"jack-不要动我","country":1100000,"province":0,"city":0,"avatar":"http://mppic-test.zone1.meitudata.com/599698ae9a256787.jpg","gender":"f","birthday":"2016-10-28","age":1,"constellation":"Scorpio","verified":true,"followers_count":197,"friends_count":172,"reposts_count":83,"videos_count":1358,"real_videos_count":1022,"photos_count":336,"locked_videos_count":53,"real_locked_videos_count":53,"locked_photos_count":0,"be_liked_count":664,"url":"http://www.meipai.com/user/1025716744?client_id=1089857299","created_at":1465192611,"has_password":false,"status":"5","is_funy_core_user":false,"funy_core_user_created_at":0,"last_publish_time":0,"level":70,"show_pendant":true,"level_hide_coins":false,"level_hide_beans":false,"has_assoc_phone":false,"is_safe_white_list":false}
         * feed_id : 6543813935699907218
         * locked : false
         * type : 5
         * caption_url_params : []
         * privacy_config : {"allow_save_medias":0,"forbid_stranger_comment":0,"forbid_comment":0,"forbid_repost":0}
         * has_watermark : 0
         * refuse_gift : false
         * new_music : null
         * follow_media_info : {"follow_type":1,"current_media_id":430232210,"follow_media_id":430232210,"follow_media_uid":1025716744,"follow_media_screen_name":"jack-不要动我","follow_start_time":0,"follow_end_time":0,"topic":"♫♬美拍430232210视频跟拍","topic_id":"6390445144672078481"}
         * convert_cover_pic : null
         * ar_magic_info : null
         * aside_info : null
         * convert_pic_size : null
         * cover_pic_resize : null
         * ad_level : N
         * first_frame_pic : null
         * first_frame_pic_size : null
         * is_safe : 1
         * is_safe2 : 0
         * cover_title :
         * dangerous_action : false
         * display_source : 1
         */

        private int id;
        private String caption;
        private String weibo_share_caption;
        private String facebook_share_caption;
        private String weixin_share_caption;
        private String weixin_friendfeed_share_caption;
        private String qzone_share_caption;
        private String qq_share_caption;
        private String instagram_share_caption;
        private String weixin_share_sub_caption;
        private String weixin_friendfeed_share_sub_caption;
        private String qzone_share_sub_caption;
        private String qq_share_sub_caption;
        private Object geo;
        private String video;
        private String url;
        private String cover_pic;
        private String pic_size;
        private int category;
        private int time;
        private boolean is_long;
        private boolean show_controls;
        private String created_at;
        private int comments_count;
        private int likes_count;
        private int reposts_count;
        private boolean is_popular;
        private UserBean user;
        private long feed_id;
        private boolean locked;
        private int type;
        private PrivacyConfigBean privacy_config;
        private int has_watermark;
        private boolean refuse_gift;
        private Object new_music;
        private FollowMediaInfoBean follow_media_info;
        private Object convert_cover_pic;
        private Object ar_magic_info;
        private Object aside_info;
        private Object convert_pic_size;
        private Object cover_pic_resize;
        private String ad_level;
        private Object first_frame_pic;
        private Object first_frame_pic_size;
        private int is_safe;
        private int is_safe2;
        private String cover_title;
        private boolean dangerous_action;
        private int display_source;
        private List<?> caption_url_params;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getWeibo_share_caption() {
            return weibo_share_caption;
        }

        public void setWeibo_share_caption(String weibo_share_caption) {
            this.weibo_share_caption = weibo_share_caption;
        }

        public String getFacebook_share_caption() {
            return facebook_share_caption;
        }

        public void setFacebook_share_caption(String facebook_share_caption) {
            this.facebook_share_caption = facebook_share_caption;
        }

        public String getWeixin_share_caption() {
            return weixin_share_caption;
        }

        public void setWeixin_share_caption(String weixin_share_caption) {
            this.weixin_share_caption = weixin_share_caption;
        }

        public String getWeixin_friendfeed_share_caption() {
            return weixin_friendfeed_share_caption;
        }

        public void setWeixin_friendfeed_share_caption(String weixin_friendfeed_share_caption) {
            this.weixin_friendfeed_share_caption = weixin_friendfeed_share_caption;
        }

        public String getQzone_share_caption() {
            return qzone_share_caption;
        }

        public void setQzone_share_caption(String qzone_share_caption) {
            this.qzone_share_caption = qzone_share_caption;
        }

        public String getQq_share_caption() {
            return qq_share_caption;
        }

        public void setQq_share_caption(String qq_share_caption) {
            this.qq_share_caption = qq_share_caption;
        }

        public String getInstagram_share_caption() {
            return instagram_share_caption;
        }

        public void setInstagram_share_caption(String instagram_share_caption) {
            this.instagram_share_caption = instagram_share_caption;
        }

        public String getWeixin_share_sub_caption() {
            return weixin_share_sub_caption;
        }

        public void setWeixin_share_sub_caption(String weixin_share_sub_caption) {
            this.weixin_share_sub_caption = weixin_share_sub_caption;
        }

        public String getWeixin_friendfeed_share_sub_caption() {
            return weixin_friendfeed_share_sub_caption;
        }

        public void setWeixin_friendfeed_share_sub_caption(String weixin_friendfeed_share_sub_caption) {
            this.weixin_friendfeed_share_sub_caption = weixin_friendfeed_share_sub_caption;
        }

        public String getQzone_share_sub_caption() {
            return qzone_share_sub_caption;
        }

        public void setQzone_share_sub_caption(String qzone_share_sub_caption) {
            this.qzone_share_sub_caption = qzone_share_sub_caption;
        }

        public String getQq_share_sub_caption() {
            return qq_share_sub_caption;
        }

        public void setQq_share_sub_caption(String qq_share_sub_caption) {
            this.qq_share_sub_caption = qq_share_sub_caption;
        }

        public Object getGeo() {
            return geo;
        }

        public void setGeo(Object geo) {
            this.geo = geo;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCover_pic() {
            return cover_pic;
        }

        public void setCover_pic(String cover_pic) {
            this.cover_pic = cover_pic;
        }

        public String getPic_size() {
            return pic_size;
        }

        public void setPic_size(String pic_size) {
            this.pic_size = pic_size;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public boolean isIs_long() {
            return is_long;
        }

        public void setIs_long(boolean is_long) {
            this.is_long = is_long;
        }

        public boolean isShow_controls() {
            return show_controls;
        }

        public void setShow_controls(boolean show_controls) {
            this.show_controls = show_controls;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public int getReposts_count() {
            return reposts_count;
        }

        public void setReposts_count(int reposts_count) {
            this.reposts_count = reposts_count;
        }

        public boolean isIs_popular() {
            return is_popular;
        }

        public void setIs_popular(boolean is_popular) {
            this.is_popular = is_popular;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public long getFeed_id() {
            return feed_id;
        }

        public void setFeed_id(long feed_id) {
            this.feed_id = feed_id;
        }

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public PrivacyConfigBean getPrivacy_config() {
            return privacy_config;
        }

        public void setPrivacy_config(PrivacyConfigBean privacy_config) {
            this.privacy_config = privacy_config;
        }

        public int getHas_watermark() {
            return has_watermark;
        }

        public void setHas_watermark(int has_watermark) {
            this.has_watermark = has_watermark;
        }

        public boolean isRefuse_gift() {
            return refuse_gift;
        }

        public void setRefuse_gift(boolean refuse_gift) {
            this.refuse_gift = refuse_gift;
        }

        public Object getNew_music() {
            return new_music;
        }

        public void setNew_music(Object new_music) {
            this.new_music = new_music;
        }

        public FollowMediaInfoBean getFollow_media_info() {
            return follow_media_info;
        }

        public void setFollow_media_info(FollowMediaInfoBean follow_media_info) {
            this.follow_media_info = follow_media_info;
        }

        public Object getConvert_cover_pic() {
            return convert_cover_pic;
        }

        public void setConvert_cover_pic(Object convert_cover_pic) {
            this.convert_cover_pic = convert_cover_pic;
        }

        public Object getAr_magic_info() {
            return ar_magic_info;
        }

        public void setAr_magic_info(Object ar_magic_info) {
            this.ar_magic_info = ar_magic_info;
        }

        public Object getAside_info() {
            return aside_info;
        }

        public void setAside_info(Object aside_info) {
            this.aside_info = aside_info;
        }

        public Object getConvert_pic_size() {
            return convert_pic_size;
        }

        public void setConvert_pic_size(Object convert_pic_size) {
            this.convert_pic_size = convert_pic_size;
        }

        public Object getCover_pic_resize() {
            return cover_pic_resize;
        }

        public void setCover_pic_resize(Object cover_pic_resize) {
            this.cover_pic_resize = cover_pic_resize;
        }

        public String getAd_level() {
            return ad_level;
        }

        public void setAd_level(String ad_level) {
            this.ad_level = ad_level;
        }

        public Object getFirst_frame_pic() {
            return first_frame_pic;
        }

        public void setFirst_frame_pic(Object first_frame_pic) {
            this.first_frame_pic = first_frame_pic;
        }

        public Object getFirst_frame_pic_size() {
            return first_frame_pic_size;
        }

        public void setFirst_frame_pic_size(Object first_frame_pic_size) {
            this.first_frame_pic_size = first_frame_pic_size;
        }

        public int getIs_safe() {
            return is_safe;
        }

        public void setIs_safe(int is_safe) {
            this.is_safe = is_safe;
        }

        public int getIs_safe2() {
            return is_safe2;
        }

        public void setIs_safe2(int is_safe2) {
            this.is_safe2 = is_safe2;
        }

        public String getCover_title() {
            return cover_title;
        }

        public void setCover_title(String cover_title) {
            this.cover_title = cover_title;
        }

        public boolean isDangerous_action() {
            return dangerous_action;
        }

        public void setDangerous_action(boolean dangerous_action) {
            this.dangerous_action = dangerous_action;
        }

        public int getDisplay_source() {
            return display_source;
        }

        public void setDisplay_source(int display_source) {
            this.display_source = display_source;
        }

        public List<?> getCaption_url_params() {
            return caption_url_params;
        }

        public void setCaption_url_params(List<?> caption_url_params) {
            this.caption_url_params = caption_url_params;
        }

        public static class UserBean {
            /**
             * id : 1025716744
             * screen_name : jack-不要动我
             * country : 1100000
             * province : 0
             * city : 0
             * avatar : http://mppic-test.zone1.meitudata.com/599698ae9a256787.jpg
             * gender : f
             * birthday : 2016-10-28
             * age : 1
             * constellation : Scorpio
             * verified : true
             * followers_count : 197
             * friends_count : 172
             * reposts_count : 83
             * videos_count : 1358
             * real_videos_count : 1022
             * photos_count : 336
             * locked_videos_count : 53
             * real_locked_videos_count : 53
             * locked_photos_count : 0
             * be_liked_count : 664
             * url : http://www.meipai.com/user/1025716744?client_id=1089857299
             * created_at : 1465192611
             * has_password : false
             * status : 5
             * is_funy_core_user : false
             * funy_core_user_created_at : 0
             * last_publish_time : 0
             * level : 70
             * show_pendant : true
             * level_hide_coins : false
             * level_hide_beans : false
             * has_assoc_phone : false
             * is_safe_white_list : false
             */

            private int id;
            private String screen_name;
            private int country;
            private int province;
            private int city;
            private String avatar;
            private String gender;
            private String birthday;
            private int age;
            private String constellation;
            private boolean verified;
            private int followers_count;
            private int friends_count;
            private int reposts_count;
            private int videos_count;
            private int real_videos_count;
            private int photos_count;
            private int locked_videos_count;
            private int real_locked_videos_count;
            private int locked_photos_count;
            private int be_liked_count;
            private String url;
            private int created_at;
            private boolean has_password;
            private String status;
            private boolean is_funy_core_user;
            private int funy_core_user_created_at;
            private int last_publish_time;
            private int level;
            private boolean show_pendant;
            private boolean level_hide_coins;
            private boolean level_hide_beans;
            private boolean has_assoc_phone;
            private boolean is_safe_white_list;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getScreen_name() {
                return screen_name;
            }

            public void setScreen_name(String screen_name) {
                this.screen_name = screen_name;
            }

            public int getCountry() {
                return country;
            }

            public void setCountry(int country) {
                this.country = country;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getConstellation() {
                return constellation;
            }

            public void setConstellation(String constellation) {
                this.constellation = constellation;
            }

            public boolean isVerified() {
                return verified;
            }

            public void setVerified(boolean verified) {
                this.verified = verified;
            }

            public int getFollowers_count() {
                return followers_count;
            }

            public void setFollowers_count(int followers_count) {
                this.followers_count = followers_count;
            }

            public int getFriends_count() {
                return friends_count;
            }

            public void setFriends_count(int friends_count) {
                this.friends_count = friends_count;
            }

            public int getReposts_count() {
                return reposts_count;
            }

            public void setReposts_count(int reposts_count) {
                this.reposts_count = reposts_count;
            }

            public int getVideos_count() {
                return videos_count;
            }

            public void setVideos_count(int videos_count) {
                this.videos_count = videos_count;
            }

            public int getReal_videos_count() {
                return real_videos_count;
            }

            public void setReal_videos_count(int real_videos_count) {
                this.real_videos_count = real_videos_count;
            }

            public int getPhotos_count() {
                return photos_count;
            }

            public void setPhotos_count(int photos_count) {
                this.photos_count = photos_count;
            }

            public int getLocked_videos_count() {
                return locked_videos_count;
            }

            public void setLocked_videos_count(int locked_videos_count) {
                this.locked_videos_count = locked_videos_count;
            }

            public int getReal_locked_videos_count() {
                return real_locked_videos_count;
            }

            public void setReal_locked_videos_count(int real_locked_videos_count) {
                this.real_locked_videos_count = real_locked_videos_count;
            }

            public int getLocked_photos_count() {
                return locked_photos_count;
            }

            public void setLocked_photos_count(int locked_photos_count) {
                this.locked_photos_count = locked_photos_count;
            }

            public int getBe_liked_count() {
                return be_liked_count;
            }

            public void setBe_liked_count(int be_liked_count) {
                this.be_liked_count = be_liked_count;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public boolean isHas_password() {
                return has_password;
            }

            public void setHas_password(boolean has_password) {
                this.has_password = has_password;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public boolean isIs_funy_core_user() {
                return is_funy_core_user;
            }

            public void setIs_funy_core_user(boolean is_funy_core_user) {
                this.is_funy_core_user = is_funy_core_user;
            }

            public int getFuny_core_user_created_at() {
                return funy_core_user_created_at;
            }

            public void setFuny_core_user_created_at(int funy_core_user_created_at) {
                this.funy_core_user_created_at = funy_core_user_created_at;
            }

            public int getLast_publish_time() {
                return last_publish_time;
            }

            public void setLast_publish_time(int last_publish_time) {
                this.last_publish_time = last_publish_time;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public boolean isShow_pendant() {
                return show_pendant;
            }

            public void setShow_pendant(boolean show_pendant) {
                this.show_pendant = show_pendant;
            }

            public boolean isLevel_hide_coins() {
                return level_hide_coins;
            }

            public void setLevel_hide_coins(boolean level_hide_coins) {
                this.level_hide_coins = level_hide_coins;
            }

            public boolean isLevel_hide_beans() {
                return level_hide_beans;
            }

            public void setLevel_hide_beans(boolean level_hide_beans) {
                this.level_hide_beans = level_hide_beans;
            }

            public boolean isHas_assoc_phone() {
                return has_assoc_phone;
            }

            public void setHas_assoc_phone(boolean has_assoc_phone) {
                this.has_assoc_phone = has_assoc_phone;
            }

            public boolean isIs_safe_white_list() {
                return is_safe_white_list;
            }

            public void setIs_safe_white_list(boolean is_safe_white_list) {
                this.is_safe_white_list = is_safe_white_list;
            }
        }

        public static class PrivacyConfigBean {
            /**
             * allow_save_medias : 0
             * forbid_stranger_comment : 0
             * forbid_comment : 0
             * forbid_repost : 0
             */

            private int allow_save_medias;
            private int forbid_stranger_comment;
            private int forbid_comment;
            private int forbid_repost;

            public int getAllow_save_medias() {
                return allow_save_medias;
            }

            public void setAllow_save_medias(int allow_save_medias) {
                this.allow_save_medias = allow_save_medias;
            }

            public int getForbid_stranger_comment() {
                return forbid_stranger_comment;
            }

            public void setForbid_stranger_comment(int forbid_stranger_comment) {
                this.forbid_stranger_comment = forbid_stranger_comment;
            }

            public int getForbid_comment() {
                return forbid_comment;
            }

            public void setForbid_comment(int forbid_comment) {
                this.forbid_comment = forbid_comment;
            }

            public int getForbid_repost() {
                return forbid_repost;
            }

            public void setForbid_repost(int forbid_repost) {
                this.forbid_repost = forbid_repost;
            }
        }

        public static class FollowMediaInfoBean {
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
    }
}
