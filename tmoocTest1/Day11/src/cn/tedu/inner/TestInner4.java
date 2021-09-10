package cn.tedu.inner;
/*
测试局部内部类
 */
public class TestInner4 {
    public static void main(String[] args) {
        new Outer4().show();
    }
}
class Outer4{
    public void show(){
        System.out.println("我是外部类的普通show方法");
        //在show()方法中创建内部类对象并调用功能
        /*
        局部内部类，位置在方法里
         */
        class Inner4{
            String name;
            int age;
            public void eat(){
                System.out.println("我是局部内部类的普通方法eat()");
            }
        }
        Inner4 i=new Inner4();
        i.eat();
        System.out.println(i.age);
        System.out.println(i.name);
    }
}
