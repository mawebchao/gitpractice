package cn.tedu.abstractClass;

public class TestAbstract {
    //抽象类不可以黄色预警
}

abstract class Phone {
    public void call() {
        System.out.println("正在打电话");
    }

    public void message() {
        System.out.println("正在发短信");
    }

    public abstract void internet();
}
class Xiaomi extends Phone{

    @Override
    public void internet() {
        System.out.println("正在上网");
    }
}
