package cn.tedu.map;

import org.junit.Test;

import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;

//本来用于完成map集合的相关练习
public class TestHashMap {
    public static void main(String[] args) {
        method1();
    }
    //提示并接受用户输入的一串字符，并统计输出每个字符出现的次数

    public static void method1(){
        System.out.println("请输入一串字符串");
        String input=new Scanner(System.in).next();
        HashMap<String,Integer> map=new HashMap<>();
        for (Character c:
                input.toCharArray()) {
            map.merge(c+"",1,(oldValue, newValue) -> oldValue + newValue);
        }
        System.out.println(map);
    }
}
