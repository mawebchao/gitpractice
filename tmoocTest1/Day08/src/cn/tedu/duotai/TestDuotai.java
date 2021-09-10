package cn.tedu.duotai;

public class TestDuotai {
    public static void main(String[] args) {
        Animal cat=new Cat();
        Animal dog=new Dog();
        cat.eat();
        dog.eat();
        ((Cat)cat).play();
        ((Dog)dog).play();
    }
}
class Animal{
    public void eat(){
        System.out.println("小动物Animal吃啥都行");
    }
}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("小猫爱吃小鱼干");
    }
    public void play(){
        System.out.println("小猫跳得好高啊");
    }
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("小狗爱吃肉骨头");
    }
    public void play(){
        System.out.println("小狗跑的好快啊");
    }
}
