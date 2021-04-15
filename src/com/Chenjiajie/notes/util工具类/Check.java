package com.Chenjiajie.notes.util工具类;

import com.Chenjiajie.notes.view放置与界面相关的代码.OtherView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check {
//检查用户名（主键）是否已被用
    public static class checkname{
        public static void checkname(String name) throws SQLException {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs =null;
            try {
                conn = Jdbcutil.getConnection();
                String sql = "SELECT `userID`  FROM USER";
                //预编译，先写SQL，不执行
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    if(rs.getString("userID").equals(name)){
                        System.out.println("该账户已存在");
                        //return 注册首页
                        new OtherView().userregister();
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                Jdbcutil.release(conn,ps,rs);
            }
        }
    }


}
