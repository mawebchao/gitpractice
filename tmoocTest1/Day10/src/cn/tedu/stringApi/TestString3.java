package cn.tedu.stringApi;

import javax.swing.plaf.synth.SynthTextAreaUI;

//将26个字母拼接10000次
public class TestString3 {
    static char[] charArr="abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        method1(charArr);
        method2(charArr);
    }
    public static void method1(char[] arr){
        String result="";
        String x=new String(arr);
        long start_time=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            result+=x;
        }
        System.out.println(System.currentTimeMillis()-start_time);
    }
    //方式二拼接字符串
    public static void method2(char[] arr){
        StringBuilder sb=new StringBuilder();
        String str=new String(arr);
        long start_time=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(str);
        }
        System.out.println(System.currentTimeMillis()-start_time);
    }
}
