package cn.tedu.cn.tedu.design;
//单例设计模式实现方案一
public class Singleton1 {
    public static void main(String[] args) {
        MySingle mySingle1=MySingle.getMySingle();
        MySingle mySingle2=MySingle.getMySingle();
        System.out.println(mySingle1==mySingle2);
        System.out.println(mySingle1);
        System.out.println(mySingle2);
    }
}
class MySingle{
    //1.提供构造方法，并且将构造方法私有化
    //无法让外界随意调用本方法实例化对象
    private MySingle(){}
    //2.创建本类对象，并且把本类对象野私有化
    private static MySingle single=new MySingle();

    //需要给外界一个公共的全局访问点
    public static MySingle getMySingle(){
        return single;
    }
}
