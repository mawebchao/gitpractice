package cn.tedu.collection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
    public static void main(String[] args) {

    }

    @Test
    public void method1() {
        List<String> list_str = new ArrayList<>();
        list_str.add("呵呵呵");
        list_str.add("吼吼吼");
        list_str.add("喝喝喝");
        list_str.add("哈哈哈");
        System.out.println(list_str.contains("哈哈哈"));
        System.out.println(list_str.remove("吼吼吼"));
        System.out.println("删除后的list长度为：" + list_str.size());
        System.out.println("打印list中的所有内容：" + Arrays.toString(list_str.toArray()));

        List<String> list_str2 = new ArrayList<>();
        list_str2.add("1");
        list_str2.add("2");
        list_str2.add("3");
        list_str2.add("4");
        System.out.println(list_str2);
        System.out.println(list_str.addAll(1,list_str2));
        System.out.println(list_str);
        System.out.println(list_str.containsAll(list_str2));
        list_str.add(1,"我是你爸爸");
        System.out.println(list_str);
        list_str.set(1,"我是你爷爷");
        System.out.println(list_str);


    }
}
