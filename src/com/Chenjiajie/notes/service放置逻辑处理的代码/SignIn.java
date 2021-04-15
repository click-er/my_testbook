/*package com.Chenjiajie.notes.service放置逻辑处理的代码;

import com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码.adminDao;
import com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码.userDao;

import com.Chenjiajie.notes.entity与数据库一一对应的实体类.admin;
import com.Chenjiajie.notes.entity与数据库一一对应的实体类.note;
import com.Chenjiajie.notes.entity与数据库一一对应的实体类.user;

import java.sql.SQLException;
import java.util.Scanner;

public class SignIn {
    public static void main(String[] args) throws SQLException {
        //实例化Dao类
        userDao userDao = new userDao();
        admin admin = new admin();
        //正常情况下是监控器起作用的，由于界面暂时没出来，就通过控制台操作

        user user = new user();
        note note = new note();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        user.setUserID(scanner.nextLine());
        System.out.println("输入的内容为："+user.getUserID());
        System.out.print("请输入密码：");
        user.setPassword(scanner.nextLine());
        System.out.println("输入的内容为："+user.getPassword());
        System.out.println("请问您的性别是：0为男性，1为女性");
        user.setUserSex(scanner.nextInt());
//        scanner.close();

        //注册
        userDao.Register(user.getUserID(),user.getPassword(),scanner.nextInt());

        //登录
        if (!userDao.Login(user.getUserID(),user.getPassword())) {
            System.out.println("登录失败，请重试");
            //重新运行
            //return main();
            System.exit(1);
        }else {
            System.out.println("登录成功");
        }

        //登录成功把昵称转进note里面
        note.setNickname(user.getUserNickname());
        //写笔记
        //把用户名转入笔记作者名
        note.setUserId(user.getUserID());
        System.out.println("文章标题：");
        note.setTitle(scanner.nextLine());
        System.out.println("文章内容：");
        note.setContent(scanner.nextLine());
        System.out.println("是否公开：（公开写1，非公开写0）");
        note.setIsPrivate(scanner.nextInt());
        userDao.Write(note.getUserId(), note.getNickname(), note.getTitle(), note.getContent(), note.getIsPrivate());

        //用户查看自己的笔记
        userDao.Look(user.getUserNickname());

        //用户删除自己的笔记
        System.out.println("请输入你想要删除的笔记的标题");
        String title = scanner.nextLine();
        userDao.Delete(title);

        //用户修改自己的笔记。先查看自己的笔记
        userDao.Look(note.getNickname());
        System.out.println("请输入需要修改的笔记标题");
        note.setTitle(scanner.nextLine());
        System.out.println("新标题：");
        note.setTitle(scanner.nextLine());
        System.out.println("内容更改为：");
        note.setContent(scanner.nextLine());
        userDao.Update(note.getNickname(), note.getTitle(), note.getContent());

        //用户搜索其他的笔记
        System.out.println("输入1进入按标题名字搜索，输入2进入按昵称搜索");
        int i = scanner.nextInt();
        if(i==1){
            System.out.println("请输入相关标题关键词");
            note.setTitle(scanner.nextLine());
            userDao.searchTitle(note.getTitle());
        }else if(i==2){
            System.out.println("请输入相关用户昵称");
            note.setNickname(scanner.nextLine());
            userDao.searchNickname(note.getNickname());
        }

    }
}

*/