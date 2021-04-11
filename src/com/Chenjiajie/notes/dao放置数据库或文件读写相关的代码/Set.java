package com.Chenjiajie.notes.dao放置数据库或文件读写相关的代码;

import com.Chenjiajie.notes.util工具类.Jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Set {
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
}
