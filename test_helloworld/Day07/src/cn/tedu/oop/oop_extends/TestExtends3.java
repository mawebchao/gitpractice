package cn.tedu.oop.oop_extends;

public class TestExtends3 {

    /*
    重写的语法规则：
    1.子类方法的修饰符范围要大于等于父类方法的修饰符范围
    2.方法名相同，参数列表相同
    3.子类方法的返回值类型小于等于父类方法的返回值类型
        子类方法抛出的异常类型小于等于父类方法的异常类型
     */
    public static void main(String[] args) {
        Son3 son3=new Son3();
        son3.eat();
        son3.studyJava();
    }
}
class Father3{
    public void eat(){
        System.out.println("爸爸爱吃肉");
    }
    public void play(){
        System.out.println("爸爸爱放风筝");
    }
}
class Son3 extends Father3{
    @Override
    public void eat(){
        System.out.println("儿子爱吃蔬菜");
    }
    public void studyJava(){
        System.out.println("我拓展了学习java的功能");
    }
}