package com.Chenjiajie.notes.entity与数据库一一对应的实体类;

public class admin {
    private String adminID;//管理员名
    private String password;//管理员密码

    public admin() {
    }

    public admin(String adminID, String password) {
        this.adminID = adminID;
        this.password = password;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
