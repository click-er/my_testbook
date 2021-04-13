package com.Chenjiajie.notes.entity与数据库一一对应的实体类;

public class user {
    private String userID;
    private String password;
    private String userNickname;//昵称
    private int userSex;//0为男，1为女
    private String userIntroduction;//自我介绍
    private String isBlack;//1为黑名单

    public user() {
    }

    public user(String userID, String password, String userNickname, int userSex, String userIntroduction, String isBlack) {
        this.userID = userID;
        this.password = password;
        this.userNickname = userNickname;
        this.userSex = userSex;
        this.userIntroduction = userIntroduction;
        this.isBlack = isBlack;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public String getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(String isBlack) {
        this.isBlack = isBlack;
    }
}
