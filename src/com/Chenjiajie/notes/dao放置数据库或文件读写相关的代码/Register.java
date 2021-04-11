package com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码;


import com.Chenjiajie.notes.util工具类.Check;
import com.Chenjiajie.notes.util工具类.Jdbcutil;

import java.sql.*;

public class Register{
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        Check.checkname.checkname("jiong");

        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "insert into user (`userID`,`password`,`userNickname`,`userSex`,`userIntroduction`) values(?,?,?,?,?)";

            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);

            //手动给参数值
            ps.setString(1,"jiong");
            ps.setString(2,"123456");
            ps.setString(3,"hong");
            ps.setInt(4,0);
            ps.setString(5,"大家好，我是小红！");

            //执行
            int i =ps.executeUpdate();
            if(i>0){
                System.out.println("注册成功！");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,null);
        }
    }


}

