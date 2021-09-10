package cn.tedu.collection;

import jdk.nashorn.internal.parser.JSONParser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

//测试collection中的常用方法
public class Test1Collection {


    public static void main(String[] args) {
        Collection<Integer> c=new ArrayList<>();
        c.add(190);
        c.add(231);
        c.add(1421);
        c.add(1231);
//        c.clear();
        System.out.println(c);

        Object[] array=c.toArray();
        System.out.println(array);
        System.out.println(Arrays.toString(array));
    }
    @Test
    public void method1(){
        Collection<Integer> c=new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        System.out.println(c);
        Collection<Integer> c2=new ArrayList<>();
        c2.add(11);
        c2.add(22);
        c2.add(33);
        //集合间的操作
        c.addAll(c2);

        System.out.println(c.containsAll(c2));
        System.out.println(c.contains(5));
        System.out.println(c);
        c.removeAll(c2);
        System.out.println(c);
    }
    @Test
    public void method2(){
        Collection<Integer> c=new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        Iterator<Integer> ic=c.iterator();
        //获取当前迭代器迭代到的元素
        while (ic.hasNext()){
            System.out.print(ic.next());
        }
        for (Integer i:
             c) {
            System.out.println(i);
        }
    }
}