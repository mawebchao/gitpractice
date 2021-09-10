package cn.tedu.testabstract;
/*
本来用于测试接口与类之间的复杂关系
 */
//接口的多继承与多实现
public class TestRelation {

}
//1.创建接口1
interface Inter1{
    void save();//保存方法
    void find();//查询方法
}
interface Inter22{
    void update();//更细方法
    void delete();//删除方法
}
//接口可以继承多个接口
//类之间只能单继承
//一个类只呢鞥有一个父类，这是java中的单继承
//但是一个类出了可以继承一个父类以外，还可以同时实现多个接口，即多实现
interface Inter3 extends Inter1,Inter22{
    //Inter3把两个接口的功能汇总到了一起
}
class Inter3Impl implements Inter3{
    @Override
    public void save() {
        System.out.println("正在保存");
    }

    @Override
    public void find() {
        System.out.println("正在查询");
    }

    @Override
    public void update() {
        System.out.println("正在更新");
    }

    @Override
    public void delete() {
        System.out.println("正在删除");
    }
}
