package com.Chenjiajie.notes.view放置与界面相关的代码;

import com.Chenjiajie.notes.util工具类.Choose;

public class MainView {
    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("  欢迎使用my_testbook ");
        System.out.println("     1.管理员登陆     ");
        System.out.println("     2.用户登陆       ");
        System.out.println("     3.用户注册       ");
        System.out.println(" 请选择你想要的操作：   ");
        System.out.println("=====================");
        new Choose().main();
    }
}
