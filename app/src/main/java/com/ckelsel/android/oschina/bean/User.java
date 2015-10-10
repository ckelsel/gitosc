package com.ckelsel.android.oschina.bean;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 用户类
 *
 * Created by ckelsel on 2015/9/4.
 */
public class User implements Serializable{
    @JsonProperty("id")
    private String mId;

    private String mCacheKey;

    @JsonProperty("username")
    private String mUserName;

    @JsonProperty("name")
    private String mName;

    @JsonProperty("bio")
    private String mBio;

    @JsonProperty("weibo")
    private String  mWeiBo;

    @JsonProperty("blog")
    private String mBlog;

    @JsonProperty("theme_id")
    private String mThemeId;

    @JsonProperty("state")
    private String mState;

    @JsonProperty("created_at")
    private String mCreateAt;

    @JsonProperty("protrait")
    private String mProtrait;

    @JsonProperty("new_protrait")
    private String mNewProtrait;

    @JsonProperty("is_admin")
    private String mIsAdmin;

    @JsonProperty("can_create_group")
    private String mCanCreateGroup;

    @JsonProperty("can_create_project")
    private String mCanCreateProject;

    @JsonProperty("can_create_team")
    private String mCanCreateTeam;

    @JsonProperty("follow")
    private String mFollow;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmCacheKey() {
        return mCacheKey;
    }

    public void setmCacheKey(String mCacheKey) {
        this.mCacheKey = mCacheKey;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmBio() {
        return mBio;
    }

    public void setmBio(String mBio) {
        this.mBio = mBio;
    }

    public String getmWeiBo() {
        return mWeiBo;
    }

    public void setmWeiBo(String mWeiBo) {
        this.mWeiBo = mWeiBo;
    }

    public String getmBlog() {
        return mBlog;
    }

    public void setmBlog(String mBlog) {
        this.mBlog = mBlog;
    }

    public String getmThemeId() {
        return mThemeId;
    }

    public void setmThemeId(String mThemeId) {
        this.mThemeId = mThemeId;
    }

    public String getmState() {
        return mState;
    }

    public void setmState(String mState) {
        this.mState = mState;
    }

    public String getmCreateAt() {
        return mCreateAt;
    }

    public void setmCreateAt(String mCreateAt) {
        this.mCreateAt = mCreateAt;
    }

    public String getmProtrait() {
        return mProtrait;
    }

    public void setmProtrait(String mProtrait) {
        this.mProtrait = mProtrait;
    }

    public String getmNewProtrait() {
        return mNewProtrait;
    }

    public void setmNewProtrait(String mNewProtrait) {
        this.mNewProtrait = mNewProtrait;
    }

    public String getmIsAdmin() {
        return mIsAdmin;
    }

    public void setmIsAdmin(String mIsAdmin) {
        this.mIsAdmin = mIsAdmin;
    }

    public String getmCanCreateGroup() {
        return mCanCreateGroup;
    }

    public void setmCanCreateGroup(String mCanCreateGroup) {
        this.mCanCreateGroup = mCanCreateGroup;
    }

    public String getmCanCreateProject() {
        return mCanCreateProject;
    }

    public void setmCanCreateProject(String mCanCreateProject) {
        this.mCanCreateProject = mCanCreateProject;
    }

    public String getmCanCreateTeam() {
        return mCanCreateTeam;
    }

    public void setmCanCreateTeam(String mCanCreateTeam) {
        this.mCanCreateTeam = mCanCreateTeam;
    }

    public String getmFollow() {
        return mFollow;
    }

    public void setmFollow(String mFollow) {
        this.mFollow = mFollow;
    }
}

