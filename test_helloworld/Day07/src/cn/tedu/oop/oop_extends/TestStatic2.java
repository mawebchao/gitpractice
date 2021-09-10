package cn.tedu.oop.oop_extends;

public class TestStatic2 {
    //1.静态资源不能调用非静态资源，其他资源之间可以互相调用
}
class Teacher{
    String name;
    public void teach(){
        System.out.println("正在授课中");
        System.out.println("age:"+Teacher.age);
        Teacher.ready();
    }
    static int age;
    public static void ready(){
        System.out.println("正在备课中");
        eat();
    }
    public static void eat(){
        System.out.println("正在吃饭中");
    }
}
