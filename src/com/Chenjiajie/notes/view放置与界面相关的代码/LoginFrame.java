package com.Chenjiajie.notes.view放置与界面相关的代码;

import com.Chenjiajie.notes.util工具类.MyMonitor;
import com.Chenjiajie.notes.util工具类.Stringutil;
import com.sun.org.apache.xpath.internal.operations.Equals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private static String loginname;
    private static String password;

    public static String getLoginname() {
        return loginname;
    }
    public static String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        //创建窗口对象
        JFrame jFrame = new JFrame("my testbook");
        jFrame.setLayout(null);

        //打开面板，方便设置位置
        JPanel jPanel1 = new JPanel();//标题面板
        JPanel jPanel2 = new JPanel();//输入面板


        //提示框jlabel
        JLabel jLabel1 = new JLabel("本地笔记系统");
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);//让文本标签居中
        JLabel jLabel2 = new JLabel("用户名:");
        JLabel jLabel3 = new JLabel("密码:");

        //输入框
        JTextField jTextField = new JTextField(12);
        JPasswordField jPasswordField = new JPasswordField(13);

        //按钮
        JButton jButton1 = new JButton("登陆");
        JButton jButton2 = new JButton("注册");

        //设置字体大小对象
        Font f1 = new Font("宋体",Font.BOLD,80);//标题字体大小
        Font f2 = new Font("宋体",Font.BOLD,30);//提示框字体大小
        Font f3 = new Font("宋体",Font.BOLD,20);//text

        //设置按钮大小，输入框大小
        jButton1.setPreferredSize(new Dimension(200,65));
        jButton2.setPreferredSize(new Dimension(200,65));
        jTextField.setPreferredSize(new Dimension(200,65));
        jPasswordField.setPreferredSize(new Dimension(200,65));

        //设置字体大小
        jLabel1.setFont(f1);
        jLabel2.setFont(f2);
        jLabel3.setFont(f2);
        jButton1.setFont(f2);
        jButton2.setFont(f2);


        //向面板中添加组件：提示框和按钮
        jPanel1.add(jLabel1);
        jPanel1.setBounds(100, 100, 1100, 120);//大标题
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel2.setBounds(500,500,1100,600);
        jPanel2.add(jButton1);
        jPanel2.add(jButton2);
        jPanel2.add(jTextField);
        jPanel2.add(jPasswordField);
        //监听器
        MyMonitor myMonitor = new MyMonitor();
        jButton1.addActionListener(myMonitor);
        jButton2.addActionListener(myMonitor);

        //向jframe中添加面板
        jFrame.add(jPanel1);
        jFrame.add(jPanel2);

        //jframe设置
        jFrame.setVisible(true);
        jFrame.setBounds(310,100,1300,800);
//        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}


