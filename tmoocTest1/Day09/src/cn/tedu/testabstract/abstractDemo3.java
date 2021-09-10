package cn.tedu.testabstract;

public class abstractDemo3 {
}

abstract class Fruit {
    int sum = 100;
    final String name = "XHR";

    public void clean() {
        System.out.println("水果要先吸再吃");
    }

    abstract public void grow();

    abstract public void clean2();
}
class Banana extends Fruit{

    @Override
    public void clean() {
        super.clean();
    }

    @Override
    public void grow() {

    }

    @Override
    public void clean2() {

    }
}
