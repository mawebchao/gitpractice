package cn.tedu.inner;
/*
本类用于测试成员内部类被static修饰
 */
public class TestInner3 {
    public static void main(String[] args) {
        Outer3.Inner3.fly();
        Outer3.Inner3 oi=new Outer3.Inner3();
        /*
        现象：当内部类被static修饰以后，new Outer3()会报错
        所以我们无需创建外部类对象，可以通过类名找到内部类
        直接创建静态内部类的对象即可
         */
        //链式加载
        Outer3.Inner3.fly();

    }
}
class Outer3{
    static class Inner3{
        public void show(){
            System.out.println("我是成员内部类inner3的普通方法show()......");
        }
        public static void fly(){
            System.out.println("我是成员内部类inner3的静态方法fly()......");
        }
    }
}