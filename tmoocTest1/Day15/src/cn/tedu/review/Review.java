package cn.tedu.review;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Review {
    @Test
    public void method1(){
        List<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        String[] str_arr=new String[]{"aaa","addd","adf","desf"};
        System.out.println(Arrays.toString(list.toArray(str_arr)));
        System.out.println(str_arr.getClass());
        System.out.println("aaa".getClass());
    }
}

class Person{
    private final boolean enableOverride;
    private String name;
    public Person(String name){
        this.name=name;
        enableOverride=false;
    }
    protected Person(){
        enableOverride=true;
    }
    public final Object read(){
        if(enableOverride)
            return readOverride();
        System.out.println("Person正在读");
        return null;
    }
    protected Object readOverride(){
        System.out.println("一个可以重写的方法");
        return null;
    }
}
class Teacher extends  Person{

}