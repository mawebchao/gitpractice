package cn.tedu.collection;

import org.junit.Test;

import java.util.LinkedList;

public class TestLinkedList {
    @Test
    public void method1(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("孙悟空");
        linkedList.add("沙僧");
        linkedList.add("猪八戒");
        linkedList.add("唐僧");

        linkedList.addFirst("奔波儿灞");
        linkedList.addFirst("灞波儿奔");
        System.out.println(linkedList);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.get(2));
    }
    @Test
    public void method2(){
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("三国演义");
        linkedList.add("水浒传");
        linkedList.add("西游记");
        linkedList.add("封神演义");

        //查询系列
        //查询首元素
        System.out.println(linkedList.peek());
        System.out.println(linkedList.peekLast());
        System.out.println(linkedList.element());
        //添加系列
        //将制指定元素添加到列表的末尾
        System.out.println(linkedList.offer("星球大爆炸"));
        System.out.println(linkedList);
        //移除系列
        System.out.println(linkedList.poll());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollLast());


    }
}
