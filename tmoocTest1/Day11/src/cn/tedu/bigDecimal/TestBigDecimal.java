package cn.tedu.bigDecimal;

import java.math.BigDecimal;
import java.util.Scanner;

public class TestBigDecimal {
    public static void main(String[] args) {
        f1();//使用普通的四则运算计算浮点数据
        f2();//使用BigDecimal来解决浮点数运算不精确的问题
    }

    private static void f2() {
        System.out.println("请输入您要计算的两个小数:");
        BigDecimal bd1=new BigDecimal(new Scanner(System.in).nextDouble()+"");
        BigDecimal bd2=new BigDecimal(new Scanner(System.in).nextDouble()+"");
        System.out.println(bd1.add(bd2));
        System.out.println(bd1.subtract(bd2));
        System.out.println(bd1.multiply(bd2));
        //roundingMode保留小数位数的方式
        //四舍五入
        System.out.println(bd1.divide(bd2,2,BigDecimal.ROUND_UP));
    }

    //会出现不精确的现象
    private static void f1() {
        //1.提示并接受用户输入的两个小数
        System.out.println("请输入您要计算的两个小数:");
        double a=new Scanner(System.in).nextDouble();
        double b=new Scanner(System.in).nextDouble();
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
    }
}
