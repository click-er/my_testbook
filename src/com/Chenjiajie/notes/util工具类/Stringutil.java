package com.Chenjiajie.notes.util工具类;

public class Stringutil {
//检验文本框输入是否为空
        public static boolean isEmpty(String str) {
            if(str == null || "".equals(str.trim())) {//trim()的作用是去掉字符串两端的多余的空格
                return true;
            }else {
                return false;
            }
        }

        public static boolean isNotEmpty(String str) {
            if(str != null && !"".equals(str.trim())) {
                return true;
            } else {
                return false;
            }
        }
}

