package com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码;

import com.Chenjiajie.notes.util工具类.Jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDao {

    public void Look() throws SQLException {
        //查看所有用户信息，一一打印
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "SELECT * FROM USER;";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("性别：0为男，1为女。");
            System.out.println("黑名单：0为非黑名单，1为黑名单。");
            while (rs.next()){
                System.out.print("用户名："+rs.getString("userID"));
                System.out.print("呢称:"+rs.getString("userNickname"));
                System.out.print("性别:"+rs.getString("userSex"));
                System.out.print("用户介绍:"+rs.getString("userIntroduction"));
                System.out.print("是否为黑名单:"+rs.getString("isBlack"));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,rs);
        }
    }

    public boolean Login(String name, String password) throws SQLException {
        //登录，与数据库存储的信息对比，一样则登录。布尔型，在业务类时根据是否成功登录可选择再次输入信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = Jdbcutil.getConnection();
            String sql = "SELECT `adminID` AS name,`password` FROM ADMIN";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                while (rs.getString("name").equals(name) &rs.getString("password").equals(password) ){
                    System.out.println("登录成功");Jdbcutil.release(conn,ps,rs);
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,rs);
        }
        System.out.println("登录失败");
        return false;
    }

}
