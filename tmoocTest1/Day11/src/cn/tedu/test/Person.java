package cn.tedu.test;

public class Person {
    public void showMessage(){
        System.out.println("打印信息");
    }

    public static void main(String[] args) {
        Person p=new Teacher();
        p.showMessage();
    }
}
class  Teacher extends Person{
    @Override
    public void showMessage() {
        System.out.println("哈哈哈");
    }
}
