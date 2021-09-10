package cn.tedu.serializable;

import org.junit.Test;

import java.io.*;

public class TestSerializalbe {
    @Test
    public void test1(){
        BufferedWriter osw=null;
        try{
            osw=new BufferedWriter(new FileWriter("D:\\ready\\test1.txt"));
            osw.write("海绵宝宝与派大星");
            System.out.println("Student写入成功");
        }catch (IOException ex){
            System.out.println("Student对象写入失败");
            ex.printStackTrace();
        }finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2(){
        InputStreamReader isr=null;
        try{
            isr=new InputStreamReader(new FileInputStream("D:\\ready\\test1.txt"),"utf-8");
            char[] cbuf=new char[8192];
            int length=-1;
            while((length=isr.read(cbuf))!=-1){
                System.out.print(cbuf);
            }
            System.out.println();
            System.out.println("Student写入成功");
        }catch (IOException ex){
            System.out.println("Student对象写入失败");
            ex.printStackTrace();
        }finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
