package cn.tedu.oop.oop_extends;

public class ExtendsDemo {
    public static void main(String[] args) {
        Animal animal=new Animal();
        Cat cat=new Cat();
        Miaomiao miao=new Miaomiao();
        miao.eat();
    }

}
class Animal {
    public void eat(){
        System.out.println("吃");
    }

}
class Cat extends Animal{


}
class Miaomiao extends Cat{


}
