package cn.tedu.stringApi;

public class TestNumber {
    static Integer i0=1;
    public static void main(String[] args) {
        System.out.println(i0.intValue());
        //方式一
        //创建int类型对应的包装类Integer类型的对象
        Integer i1=new Integer(5);
        Integer i11=new Integer(5);
        System.out.println(i1==i11);
        //方式二
        //Integer类型有一个搞笑的效果，数据在(-128~127)范围内相同的数据只会存一次，之后再存只会使用相同的数据
        Integer i2=Integer.valueOf(1287);
        Integer i3=Integer.valueOf(1287);
        System.out.println(i1==i2);
        System.out.println(i2==i3);
        //创建double类型对应包装类Double的对象
        Double d1=new Double(3.14);
        Double d2=Double.valueOf(3.14);
        Double d3=Double.valueOf(3.14);
        System.out.println(d1==d2);
        System.out.println(d2==d3);
        //只有Integer的valueof创建方式，并且数据在-128~127才会有高效的效果
    }
}
