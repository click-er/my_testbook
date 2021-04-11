package com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码;

import com.Chenjiajie.notes.util工具类.Jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
    public void searchTitle(String title) throws SQLException {
        //按照标题模糊查询公开的笔记
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = Jdbcutil.getConnection();
            String sql = "SELECT  title,content FROM note WHERE `isPrivate`= '1' AND title LIKE '%'?'%'";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            //手动给参数值
            ps.setString(1,title);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("title:"+rs.getString("title"));
                System.out.println("content:"+rs.getString("content"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,rs);
        }
    }

    public void searchNickname(String nickname) throws SQLException {
        //根据昵称模糊查询公开笔记
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "select  title,content from note `isPrivate`= '1' AND nickname LIKE '%'?'%'";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            //手动给参数值
            ps.setString(1,nickname);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("title:"+rs.getString("title"));
                System.out.println("content:"+rs.getString("content"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,rs);
        }
    }
}
