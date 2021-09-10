package cn.tedu.serializable;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
public class TestJsonSerializable {
    @Test
    public void writeJsonObjectArray(){
        Student s1=new Student("大傻逼",20,"上海市",'男');
        Student s2=new Student("大傻逼",10,"上海市",'男');
        Student s3=new Student("大傻逼",20,"上海市",'5');
        Student s4=new Student("大傻逼",20,"上海市",'2');
        Student s5=new Student("大傻逼",50,"上海市",'2');

        Student[] ss=new Student[]{s1,s2,s3,s4,s5};

        BufferedWriter bw=null;

        try{
            bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\ready\\test1.txt"),"utf-8"));
            bw.write(Arrays.toString(ss));
            System.out.println("Student数组写入成功");
        }catch (IOException ex){
            System.out.println("Student数组写入失败");
            ex.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void readJsonObjectArray(){

//        Student[] ss=null;
//
//        Buffere bw=null;
//        try{
//            bw=new BufferedWriter(new FileWriter("D:\\ready\\test1.txt"));
//            bw.write(Arrays.toString(ss));
//            System.out.println("Student数组写入成功");
//        }catch (IOException ex){
//            System.out.println("Student数组写入失败");
//            ex.printStackTrace();
//        }finally {
//            try {
//                bw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
