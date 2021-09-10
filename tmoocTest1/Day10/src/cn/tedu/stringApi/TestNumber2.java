package cn.tedu.stringApi;
/*
自动装箱与自动拆箱
 */
public class TestNumber2 {
    public static void main(String[] args) {
        Integer i1=new Integer(127);
        Integer i11=Integer.valueOf(127);
        //自动装箱，底层发生的代码就是Integer.valueOf
        Integer i3=3;
        //自动拆箱(编译器会自动把包装类型的i1拆掉箱子，变回基本类型的数据)
        int i4=i1;
    }
}
