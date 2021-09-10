package cn.tedu.oop.oop_extends;

public class TestStaticOop {
    //可以通过static关键字来修饰成员变量与方法，修饰方法一般写在权限修饰符之后
    //被static修饰的资源称作静态资源
    //静态资源优先于对象进行加载，它是随着类的加载而加载的，比对象先加载进入内存，所以没对象是也可以通过类名直接调用
    /*
    静态资源被全局所有对象共享
     */
    public static void main(String[] args) {
        Student s=new Student();
        System.out.println("修改前：*************");
        System.out.println(s.name);
        System.out.println(Student.name);
        //测试静态变量的修改
        s.name="黄桃罐头";
        System.out.println("修改后：*************");
        System.out.println(s.name);
        System.out.println(Student.name);
        Student s1=new Student();
        System.out.println(s1.name);
        System.out.println(Student.name);
    }
}
class Student{
    int sno;
    static String name;
    public static void study(){
        System.out.println("别闹，学java呢");
    }
    public static void speak(){
        System.out.println("会要大声说出来");
    }
}
