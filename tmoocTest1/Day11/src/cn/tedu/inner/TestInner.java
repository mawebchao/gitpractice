package cn.tedu.inner;

public class TestInner {
    public static void main(String[] args) {
        //创建外部类
        Outer o=new Outer();
        //内部类的对象
        Outer.Inner i=o.new Inner();
        //需要创建内部类的对象来使用内部类的方法

        //外部类如何使用内部类的资源
        /*
        外部类如果想要使用内部类的资源，需要现创建内部类的资源，通过
        内部类对象来调用内部类的资源
         */
        i.delete();
        //测试内部类是否可以使用外部类的方法
    }
}
class Outer{
    String name;
    private int age;
    public void find(){
        System.out.println("我是外部类的成员方法");
    }
    //创建内部类---成员内部类
    /*
    根据内部类所处位置的不同，我们可以把内部类分为：
    1.成员内部类（类内方法外）
    2.局部内部类（方法里）
     */
    class Inner{
        int sum=10;
        public void delete(){
            System.out.println("我是成员内部类inner的delete方法");
            System.out.println("外部类成员age:"+age);
        }
    }
}

