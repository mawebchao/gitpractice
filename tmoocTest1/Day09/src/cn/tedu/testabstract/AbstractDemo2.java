package cn.tedu.testabstract;

public class AbstractDemo2 {
    public static void main(String[] args) {
        Pig2 p=new Pig2();//纯子类对象

    }
}

abstract class Animal2 {
    public Animal2() {
        System.out.println("我是Animal2类的构造方法");
    }
}

class Pig2 extends Animal2 {

}