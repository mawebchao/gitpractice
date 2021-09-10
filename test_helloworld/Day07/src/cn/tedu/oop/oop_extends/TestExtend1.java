package cn.tedu.oop.oop_extends;
/*
本来用于测试继承中成员变量的使用
 */
public class TestExtend1 {
    public static void main(String[] args) {
        new Son().eat();
    }
}
class Father{
    //定义父类的成员变量
    int count=1;
    int sum=2;
}
class Son extends Father{
    int sum=100;
    public void eat(){
        int sum=10;
        System.out.println(sum);
        System.out.println(this.sum);
        System.out.println(super.sum);
    }
}
