package com.Chenjiajie.notes.service放置逻辑处理的代码;

import com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码.userDao;
import com.Chenjiajie.notes.entity与数据库一一对应的实体类.note;
import com.Chenjiajie.notes.entity与数据库一一对应的实体类.user;
import com.Chenjiajie.notes.view放置与界面相关的代码.OtherView;

import java.sql.SQLException;
import java.util.Scanner;

public class userService {
    //将信息输入进Dao层，并解决dao层抛出的异常
    //记得要在每一个方法完成后返回选择界面！！！
    user user = new user();
    note note = new note();
    userDao userDao = new userDao();
    Scanner scanner = new Scanner(System.in);

    public void registerservice(){//注册业务，按要求填写相关信息，传入数据库
        System.out.print("请输入用户名：");
        user.setUserID(scanner.nextLine());
        System.out.println("输入的内容为："+user.getUserID());
        System.out.print("请输入密码：");
        user.setPassword(scanner.nextLine());
        System.out.println("输入的内容为："+user.getPassword());
        System.out.println("请问您的性别是：0为男性，1为女性");
        user.setUserSex(scanner.nextInt());
//        scanner.close();//释放scanner
        try {
            userDao.Register(user.getUserID(),user.getPassword(),scanner.nextInt());
            new OtherView().userview();//操作完成回到用户主界面选择其他功能
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void loginservice(){//登录业务
        System.out.print("请输入用户名：");
        user.setUserID(scanner.nextLine());
        System.out.println("输入的内容为："+user.getUserID());
        System.out.print("请输入密码：");
        user.setPassword(scanner.nextLine());
//        scanner.close();//释放scanner
        try {
            if (!userDao.Login(user.getUserID(),user.getPassword())) {
                System.out.println("登录失败，请重试");
                //重新运行
                new userService().loginservice();
            }else {
                System.out.println("登录成功");
                note.setUserId(user.getUserID());
                new OtherView().userview();//操作完成回到用户主界面选择其他功能
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setservice(){//设置业务，填写信息再更新数据库信息。登录或注册后将用户名传入
        System.out.print("请输入您的昵称");
        user.setUserNickname(scanner.nextLine());
        System.out.println("输入的内容为："+user.getUserNickname());
        System.out.print("请输入您的自我介绍");
        user.setUserIntroduction(scanner.nextLine());
        System.out.println("输入的内容为："+user.getUserIntroduction());
//        scanner.close();//释放scanner
        try {
            userDao.Set(user.getUserID(), user.getUserNickname(), user.getUserIntroduction());
            new OtherView().userview();//操作完成回到用户主界面选择其他功能
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            new OtherView().userview();//异常操作，回到用户主界面选择其他功能
        }
    }

    public void writeservice(){//创建新笔记
        note.setUserId(user.getUserID());//将user类的用户名转入note的用户名（一个不可变的标识）
        System.out.println("文章标题：");
        note.setTitle(scanner.nextLine());
        System.out.println("文章内容：");
        note.setContent(scanner.nextLine());
        System.out.println("是否公开：（公开写1，非公开写0）");
        note.setIsPrivate(scanner.nextInt());
        try {
            userDao.Write(note.getUserId(), note.getNickname(), note.getTitle(), note.getContent(), note.getIsPrivate());
            new OtherView().userview();//操作完成回到用户主界面选择其他功能
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            new OtherView().userview();//异常操作，回到用户主界面选择其他功能
        }
    }

    public void lookservice(){//查找历史记录业务
        try {
            userDao.Look(user.getUserNickname());
            new OtherView().userview();//操作完成回到用户主界面选择其他功能
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            new OtherView().userview();//异常操作，回到用户主界面选择其他功能
        }
    }

    public void titleservice(){//按标题搜索，显示公开的相关笔记
        System.out.println("请输入相关标题关键词");
        note.setTitle(scanner.nextLine());
        try {
            userDao.searchTitle(note.getTitle());
            new OtherView().userview();//操作完成回到用户主界面选择其他功能
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            new OtherView().userview();//异常操作，回到用户主界面选择其他功能
        }
    }

    public void nicknameservice(){//按昵称搜索，显示公开的相关笔记
        System.out.println("请输入相关用户昵称");
        note.setNickname(scanner.nextLine());
        try {
            userDao.searchNickname(note.getNickname());
            new OtherView().userview();//操作完成回到用户主界面选择其他功能
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            new OtherView().userview();//异常操作，回到用户主界面选择其他功能
        }
    }

    public void updateservice(){//更新笔记
        try {
            userDao.Look(note.getNickname());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("请输入需要修改的笔记标题");
        note.setTitle(scanner.nextLine());
        System.out.println("新标题：");
        note.setTitle(scanner.nextLine());
        System.out.println("内容更改为：");
        note.setContent(scanner.nextLine());
        try {
            userDao.Update(note.getNickname(), note.getTitle(), note.getContent());
            new OtherView().userview();//操作完成回到用户主界面选择其他功能
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            new OtherView().userview();//异常操作，回到用户主界面选择其他功能
        }
    }

    public void deleteservice(){//删除自己已有的笔记
        System.out.println("请输入你想要删除的笔记的标题");
        String title = scanner.nextLine();
        try {
            userDao.Delete(title);
            new OtherView().userview();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            new OtherView().userview();//异常操作，回到用户主界面选择其他功能
        }
    }

}
