package cn.tedu.oop.oop_extends;
/*
本类用于学习静态代码块
静态代码块，在每次创建对象时都会被执行，并且会优先于构造方法
 */
public class TestStaticBlock {

    //静态代码块也属于静态资源，随着类的加载 而加载，优先于对象加载并且静态资源只会加载一次
    public static void main(String[] args) {
        Person p=new Person();
        Person p2=new Person();
    }
}
class  Person{
    {
        System.out.println("我是构造代码块");
    }
    static{
        System.out.println("我是静态代码块");
    }
    public void play(){
        System.out.println("我是一个普通方法");
        {
            System.out.println("我是一个局部代码块");
        }
    }
}