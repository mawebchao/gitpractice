package cn.tedu.stringApi;

import java.util.Locale;

public class TestString2 {
    public static void main(String[] args) {
        String s="abccccc";
        char[] value=new char[]{'a','b','c'};
        System.out.println(s.charAt(1));//获取String中对应位置的字符
        System.out.println(s.concat("cxy"));//拼接字符串，（但是没有改变原先的字符串）
        System.out.println(s.startsWith("a",0));
        System.out.println(s.indexOf('b'));//获取指定元素第一次出现的索引值
        System.out.println(s.lastIndexOf('c'));//获取指定元素最后一次出现的索引值
        System.out.println(s.length());
        s.split(" ");
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(3));
        System.out.println(s.substring(3,5));
        System.out.println(s.trim());//去除字符串两端多余的空格
    }
}

