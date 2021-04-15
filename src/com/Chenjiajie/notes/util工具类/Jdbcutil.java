package com.Chenjiajie.notes.util工具类;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Jdbcutil {
//JDBC工具类，链接数据库，以及释放连接
    private static String driver =null;
    private static String url =null;
    private static String username =null;
    private static String password =null;

    static {
        try {
            //获取文件的资源
            InputStream in = Jdbcutil.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //加载驱动
            Class.forName(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection()throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void release(Connection conn, Statement st, ResultSet rs) throws SQLException {
        //释放连接资源
        if(rs!=null){
            rs.close();
        }
        if(st!=null){
            st.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
}
