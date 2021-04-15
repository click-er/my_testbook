package com.Chenjiajie.notes.util工具类;

import com.Chenjiajie.notes.view放置与界面相关的代码.MainView;
import com.Chenjiajie.notes.view放置与界面相关的代码.OtherView;
import com.Chenjiajie.notes.service放置逻辑处理的代码.*;

import java.util.Scanner;

import static com.sun.deploy.trace.Trace.flush;

public class Choose {

    public int num() {
        flush();
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
//        String n =scanner.nextLine();
        flush();
        return i;
    }
//突然想起来可以改用switch case!!!
    public void main() {
        if (num() == 1) {//管理员登陆
            new OtherView().adminlogin();
        } else if (num() == 2) {//用户登陆
            new OtherView().userlogin();
        } else if (num() == 3) {//用户注册
            new OtherView().userregister();
        } else {
            System.out.println("输入有误，请重新选择。(1-3)");
            num();
        }
    }

    public void userchoose() {
        if (num() == 1) {//设置个人信息
            new OtherView().setview();
        } else if (num() == 2) {//创建新笔记
            new OtherView().writeview();
        } else if (num() == 3) {//查看历史笔记
            new userService().lookservice();
        } else if (num() == 4) {//修改笔记
            new userService().updateservice();
        } else if (num() == 5) {//删除笔记
            new userService().deleteservice();
        } else if (num() == 6) {//搜索已公开的笔记
            new OtherView().searchview();
        } else if(num()==7) {
            System.exit(0);
        }else {
            System.out.println("输入有误，请重新选择。(1-6)");
            num();
            }
        }

    public void searchchoose() {
        if (num() == 1) {//按标题搜索
            new userService().titleservice();
        } else if (num() == 2) {//按用户昵称搜索
            new userService().nicknameservice();
        } else {
            System.out.println("输入有误，请重新选择。(1-2)");
            num();
        }
    }

    public void adminchoose() {
        if (num() == 1) {//查看所有用户信息，暂无删除功能
            new adminService().lookservice();
        } else if(num()==3) {
            System.exit(0);
        }else {
            System.out.println("输入有误，请重新选择。(1或3)");
            num();
        }
    }
}

