package cn.tedu.testabstract;

public class ReviewAbstract {
    public static void main(String[] args) {
        Animal pig=new Pig();
    }
}
abstract class Animal{
    public void eat(){
        System.out.println("吃东西");
    }
    public void play(){
        System.out.println("正在玩");
    }
    public abstract void jump();
    public abstract void jump2();

}
class Pig extends Animal{

    @Override
    public void jump() {
        System.out.println("实现父类的抽象方法");
    }

    @Override
    public void jump2() {
        System.out.println("实现父类的抽象方法");
    }
}