package cn.tedu.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
本类用于异常的测试
 */
public class TestException {
    public static void main(String[] args) {
//        method1();
        method2();
        method3();
    }
    public static void method1(){
        System.out.println("请您输入要计算的第一个数：");
        int a=new Scanner(System.in).nextInt();
        System.out.println("请您输入要计算的第一个数：");
        int b=new Scanner(System.in).nextInt();
        System.out.println("计算结果为："+a/b);
    }
    public static void method2(){
        try {
            System.out.println("请您输入要计算的第一个数：");
            int a=new Scanner(System.in).nextInt();
            System.out.println("请您输入要计算的第一个数：");
            int b=new Scanner(System.in).nextInt();
            System.out.println("计算结果为："+a/b);
        }catch(InputMismatchException e){
            System.out.println("输入格式异常");
        }catch (ArithmeticException e){
            System.out.println("除数不能为0");
        }
    }
    public static void method3(){

    }
}
