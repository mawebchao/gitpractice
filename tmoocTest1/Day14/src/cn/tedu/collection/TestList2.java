package cn.tedu.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//用于测试List接口的多态对象
public class TestList2 {
    @Test
    public void method1(){
        List<String> list=new ArrayList<>();
        list.add("美羊羊");;
        list.add("喜洋洋");
        list.add("天线宝宝");
        list.add("奥特曼");
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i));
        }
        for (String s:
            list ) {
            System.out.println(s);
        }
    }
    @Test
    public void method2(){
        List<String> list=new ArrayList<>();
        list.add("美羊羊");;
        list.add("喜洋洋");
        list.add("天线宝宝");
        list.add("奥特曼");
        Iterator ir=list.iterator();
        while(ir.hasNext()){
            System.out.print(ir.next()+(ir.hasNext()?",":""));
        }
        System.out.println();
    }
    @Test
    public void method3(){
        /**
         * ListIterator<E> 子接口--除了父类的功能以外，
         * 还有自己的特有功能，比如你序遍历，添加元素等等，但是都很少用
         */
    }
}
