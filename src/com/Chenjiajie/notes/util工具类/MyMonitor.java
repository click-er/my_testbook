package com.Chenjiajie.notes.util工具类;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMonitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //确定是什么名字的按钮，实现不同功能
        if(e.getActionCommand().equals("登陆")){
            System.out.println("登陆");
        }
        if(e.getActionCommand().equals("注册")){
            System.out.println("注册");
        }
    }
}
