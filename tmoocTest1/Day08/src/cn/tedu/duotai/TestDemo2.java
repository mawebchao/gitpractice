package cn.tedu.duotai;
/*
本类用于测试多态中元素的使用情况
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Animal2 a2=new Animal2();
        Dog2 d2=new Dog2();
        Animal2 d=new Dog2();//多态对象
        //1.测试d2的eat方法
        d2.eat();
        //2.测试d2的play方法
        d2.play();
        //3.父类成员变量打印（结论：多态中成员变量使用的都是父类的）
        System.out.println(d.sum);
        //4.多态中，成员方法的定义使用的是父类的，实现使用的是子类的
        d.eat();
    }
}
class Animal2{
    int sum=10;
    public void eat(){
        System.out.println("吃啥都行");
    }
    public static void play(){
        System.out.println("玩啥都行");
    }
}
class Dog2 extends Animal2{
    int sum=20;
    //重写父类eat方法

    @Override
    public void eat() {
        System.out.println("小狗爱吃肉包子");
    }
    //静态方法不存在重写的现象，是只属于类的
    public static void play(){
        System.out.println("小狗爱打滚");
    }
}
