package cn.tedu.stringApi;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Scanner;

public class TestRegex {
    //提示并接受用户输入的身份证号
    public static void main(String[] args) {
        System.out.println("请输入身份证号：");
        String sfzh=new Scanner(System.in).next();
        String regex="\\d{17}[0-9X]";
        if(sfzh.matches(regex)){
            System.out.println("您输入正确");
        }else{
            System.out.println("输入的身份证号格式不正确");
        }
    }
}
//八大基本类型
//byte,short,char,int,long,double,float,boolean