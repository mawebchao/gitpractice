package cn.tedu.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

//本类用于测试Arraylist实现类
public class TestArrayList {
    @Test
    public void method1(){
        //底层会自动帮我们创建数组来存放Integer类型的元素，并且数组的初始容量为10
        ArrayList<Integer> list=new ArrayList<>();
        list.add(300);
        System.out.println(list);
        System.out.println(list.indexOf(400));
        list.add(400);
        System.out.println(list.indexOf(400));
        list.add(400);
        System.out.println(list.lastIndexOf(400));
        list.set(1,77);
        //删除元素300
        System.out.println(list);
        list.remove(list.indexOf(300));
        System.out.println(list);
        System.out.println(list.size());

        Iterator<Integer> it= list.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+(it.hasNext()?",":""));
        }
    }
}
