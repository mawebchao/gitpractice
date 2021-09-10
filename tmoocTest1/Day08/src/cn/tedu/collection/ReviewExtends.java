package cn.tedu.collection;

public class ReviewExtends {


    public static void main(String[] args) {
        Animal a=new Animal();
        Dog d=new Dog();
        Wangcai w=new Wangcai();
        w.play();
    }
}


class Animal{

    public void eat(){
        System.out.println("小动物，吃啥都行");
    }
    public void play(){
        System.out.println("小动物玩啥都行");
    }

}
class Dog extends Animal{
    int age;
    private String name;
    public Dog(){}
    public Dog(String name){
        System.out.println("这只小狗的名字时："+name);
    }

    @Override
    public void play() {
        System.out.println("小狗跑的可快了");
    }
}
class Wangcai extends Dog{
    int age=10;
    public Wangcai(){
        super("肉骨头");
    }
    public void play(){
        int age=100;
        System.out.println(age);
        System.out.println(this.age);
        System.out.println(super.age);
    }

}
class Xiaobai extends Dog{

}
