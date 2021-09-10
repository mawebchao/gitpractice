package cn.tedu.inner;
/*
本类用于测试成员内部类被private修饰
 */
public class TestInner2 {

    public static void main(String[] args) {
        //使用内部类的eat()
//      Outer2.Inner2 oi=new Outer2().new Inner2();
        //如果inner2成员内部类被private修饰，无法直接创建对象，该怎么办
        new Outer2().getInner2Eat();
    }

}

//1.创建外部类Outer2
class Outer2{
    //对外提供公共的方法，在方法内部创建私有内部类Inner2的对象，调用它的方法
    public void getInner2Eat(){
        Inner2 in=new Inner2();
        in.eat();
    }
    private class Inner2{
        //内部类的普通方法
        public void eat(){
            System.out.println("我是私有成员内部类的普通方法eat()....");
        }
    }
}

