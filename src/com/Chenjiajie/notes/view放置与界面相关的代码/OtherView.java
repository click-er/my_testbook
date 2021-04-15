package com.Chenjiajie.notes.view放置与界面相关的代码;


import com.Chenjiajie.notes.service放置逻辑处理的代码.*;
import com.Chenjiajie.notes.util工具类.Choose;

public class OtherView {
    public void userlogin(){
        new userService().loginservice();
    }

    public void adminlogin(){
        new adminService().loginservice();
    }

    public void userregister(){
        new userService().registerservice();
    }

    public void userview(){
 //       System.out.println("欢迎您，"+user.getUserNickname());
        System.out.println("请选择你想要的操作：     ");
        System.out.println("     1.设置个人信息     ");
        System.out.println("     2.创建新笔记       ");
        System.out.println("     3.查看历史笔记     ");//查看完自己的笔记后才可进行删除和修改
        System.out.println("     4.修改已有笔记     ");
        System.out.println("     5.删除已有笔记     ");
        System.out.println("     6.搜索已公开的笔记  ");
        System.out.println("     7.退出笔记系统     ");
        new Choose().userchoose();
    }

    public void adminview(){
//        System.out.println("管理员"+ admin.getAdminID()+"，您好");
        System.out.println("请选择你想要的操作：     ");
        System.out.println("     1.查看所有用户信息     ");
        System.out.println("     2.删除用户笔记（暂无）  ");
        System.out.println("     3.退出系统            ");
        new Choose().adminchoose();
    }

    public void setview(){
        //设置用户个人信息
        new userService().setservice();
    }

    public void writeview(){
        new userService().writeservice();
    }

    public void searchview(){
        System.out.println("请选择你想要的操作：     ");
        System.out.println("     1.按标题搜索         ");
        System.out.println("     2.按昵称搜索         ");
        new Choose().searchchoose();
    }
}
