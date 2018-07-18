package com.meitu.qihangni.feedtimelineproject.bean;

/**
 * @author nqh 2018/7/18
 */
public class PrivacyConfigBean {
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