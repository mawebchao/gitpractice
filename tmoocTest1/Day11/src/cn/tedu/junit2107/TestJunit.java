package cn.tedu.junit2107;

import org.junit.Test;

import java.util.Scanner;

/*
本类用于学习单元测试方法
 */
public class TestJunit {
    //1.创建程序的入口函数--不用
    //2.单元测试方法的要求(Junit是单元测试的最小单位)
    //语法要求：@Test+void+没有参数+public
    //junit使用前需要导包
    /*
    Add Junit4 library to the build path:import org.junit.Test
     */
    @Test
    public void test4(){
        int n=new Scanner(System.in).nextInt();
        if(n==1){
            System.out.println("今天中午吃麻辣烫");
        }else{
            System.out.println("今天中午吃水饺");
        }
    }
}
