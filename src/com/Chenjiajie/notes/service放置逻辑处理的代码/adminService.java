package com.Chenjiajie.notes.service放置逻辑处理的代码;

import com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码.adminDao;

import com.Chenjiajie.notes.entity与数据库一一对应的实体类.admin;
import com.Chenjiajie.notes.entity与数据库一一对应的实体类.user;
import com.Chenjiajie.notes.view放置与界面相关的代码.OtherView;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.SQLException;
import java.util.Scanner;

import static com.sun.deploy.trace.Trace.flush;

public class adminService {
    Scanner scanner = new Scanner(System.in);
    admin admin = new admin();
    adminDao adminDao = new adminDao();

        public void lookservice(){//管理员查看所有用户信息
           //查看完以后直接返回选择操作页面
            try {
                new adminDao().Look();
                new OtherView().adminview();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    public void loginservice(){//管理员登陆
//        flush();
        System.out.print("请输入用户名：");
        admin.setAdminID(scanner.nextLine());
//        flush();
        System.out.println("输入的内容为："+ admin.getAdminID());
        System.out.print("请输入密码：");
        admin.setPassword(scanner.nextLine());
 //       flush();
//      scanner.close();//释放scanner
        try {
            if (!adminDao.Login(admin.getAdminID(),admin.getPassword())) {
                System.out.println("登录失败，请重试");
                //重新运行
                new userService().loginservice();
            }else {
                System.out.println("登录成功");
                new OtherView().adminview();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
