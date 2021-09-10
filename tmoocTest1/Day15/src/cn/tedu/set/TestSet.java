package cn.tedu.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;


public class TestSet {
    @Test
    public void method1(){
        HashSet<String> set=new HashSet<>();
        set.add("frded");
        set.add("freadsf");
        set.add("gretg ");
        set.add("gvrefdgvre");
        set.add(null);
        Iterator<String> i=set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println(set);
    }
    @Test
//    完成set代码测试的常用方法测试、集合间的测试、集合的迭代
    public void method2(){
        HashSet<String> set=new HashSet<>();
        set.add("frded");
        set.add("freadsf");
        set.add("gretg ");
        set.add("gvrefdgvre");
        set.add(null);
        System.out.println("set元素清空前的内容："+set);
        System.out.println("set元素清空前的大小："+set.size());
        System.out.println("是否包含abcd："+set.contains("abcd"));
        System.out.println("是否包含freadsf："+set.contains("freadsf"));
        set.remove("freadsf");
        System.out.println("删除后，是否包含freadsf"+set.contains("freadsf"));
        Iterator<String> i=set.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        set.clear();
        System.out.println("set元素清空后的内容："+set);
        System.out.println("set元素清空前的大小："+set.size());
    }
}
