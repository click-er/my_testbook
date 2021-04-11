package com.Chenjiajie.notes.entity与数据库一一对应的实体类;

public class note {
    private String userId;
    private String title;
    private String content;
    private String isPrivate;
    private String ok;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
