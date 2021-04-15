package com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码;

import com.Chenjiajie.notes.util工具类.Check;
import com.Chenjiajie.notes.util工具类.Jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {
    public void Register(String name, String password,int sex) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Check.checkname.checkname(name);
        String nickname = name;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "insert into user (`userID`,`password`,`userNickname`,`userSex`) values(?,?,?,?)";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            //传输参数值
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, nickname);
            ps.setInt(4, sex);
            //执行
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("注册成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Jdbcutil.release(conn, ps, null);
        }
    }

    public void Write(String use,String nickname,String title,String content,int isPrivate) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "insert into note (`useID`,`nickname`,`title`,`content`,`isPrivate`) values(?,?,?,?,?)";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            //手动给参数值
            ps.setString(1,use);
            ps.setString(2,nickname);
            ps.setString(3,title);
            ps.setString(4,content);
            ps.setInt(5,isPrivate);
            //执行
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("发布成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,null);
        }
    }

    public boolean Login(String name, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = Jdbcutil.getConnection();
            String sql = "SELECT `userID` as name,`password` FROM USER";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                while (
                    rs.getString("name").equals(name) &rs.getString("password").equals(password) ){
                    System.out.println("正确");Jdbcutil.release(conn,ps,rs);
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,rs);
        }
        System.out.println("错误");
        return false;
    }

    public void Delete(String title) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "delete from note where title = ?";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            //手动给参数值
            ps.setString(1,title);
            //执行
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("删除成功！");
            }else if(i==0){
                System.out.println("未找到该笔记");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,null);
        }
    }

    public void Look(String nickname) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "select title,content from note where nickname = ?";
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

    public void Set(String use,String nickname,String introduction) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "update user set `userNickname` = ? , `userIntroduction` = ? where userID = ?";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            //手动给参数值
            ps.setString(1,nickname);
            ps.setString(2,introduction);
            ps.setString(3,use);
            //执行
            int i =ps.executeUpdate();
            if(i>0){
                System.out.println("设置成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,null);
        }
    }

    public void Update(String nickname,String title,String content) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Jdbcutil.getConnection();
            //使用？占位符代替参数
            String sql = "UPDATE note SET content = ? WHERE title = ? and nickname = ?";
            //预编译，先写SQL，不执行
            ps = conn.prepareStatement(sql);
            //传参数值
            ps.setString(1,content);
            ps.setString(2,title);
            ps.setString(3,nickname);
            //执行
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("发布成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Jdbcutil.release(conn,ps,null);
        }
    }

    public void save(){
        //写完笔记以后按保存按钮
    }
}
