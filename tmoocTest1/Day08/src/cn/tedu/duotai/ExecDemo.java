package cn.tedu.duotai;

public class ExecDemo {
    public static void main(String[] args) {
        Car c=new Car();
        System.out.println(c.getColor());
        c.start();
        c.stop();

        BMW bmw=new BMW();
        System.out.println(bmw.color);
        bmw.start();
        bmw.stop();

        //多态对象测试
        Car tesla=new Tesla();
        tesla.start();
        tesla.stop();

    }
}
class Car{

    private String brand;
    private String color;
    private double price;
    private double size;

    public void start(){
        System.out.println("启动我心爱的小车车");
    }
    public void stop(){
        System.out.println("停止我的小车车");
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

}

class BMW extends Car{
    String color="五彩斑斓的黑";

    @Override
    public void start() {
        System.out.println("咻咻咻，发射成功");
    }
}

class Tesla extends Car{
    @Override
    public void start() {
        System.out.println("启动特斯拉");
    }

    public void fly(){
        System.out.println("特斯拉会飞的");
    }
    String color="黑不溜秋的白";
}