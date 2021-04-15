package com.Chenjiajie.notes.view放置与界面相关的代码;


import com.Chenjiajie.notes.service放置逻辑处理的代码.*;
import com.Chenjiajie.notes.util工具类.Choose;

public class OtherView {
    //除了主界面的其他界面
    public void userlogin(){//登录页面直接跳转到业务类输入信息
        new userService().loginservice();
    }

    public void adminlogin(){//跳转到管理员登录业务
        new adminService().loginservice();
    }

    public void userregister(){//跳转到用户注册业务
        new userService().registerservice();
    }

    public void userview(){//显示用户的功能栏，跳转到选择功能
 //       System.out.println("欢迎您，"+user.getUserNickname());
        System.out.println("请选择你想要的操作：     ");
        System.out.println("     1.设置个人信息     ");
        System.out.println("     2.创建新笔记       ");
        System.out.println("     3.查看历史笔记     ");
        System.out.println("     4.修改已有笔记     ");
        System.out.println("     5.删除已有笔记     ");
        System.out.println("     6.搜索已公开的笔记  ");
        System.out.println("     7.退出笔记系统     ");
        new Choose().userchoose();
    }

    public void adminview(){//显示管理员的功能栏，跳转到选择功能
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

    public void writeview(){//跳转到输入业务
        new userService().writeservice();
    }

    public void searchview(){//显示搜索类型，跳转到选择功能
        System.out.println("请选择你想要的操作：     ");
        System.out.println("     1.按标题搜索         ");
        System.out.println("     2.按昵称搜索         ");
        new Choose().searchchoose();
    }
}
