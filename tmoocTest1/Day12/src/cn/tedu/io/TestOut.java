package cn.tedu.io;

import org.junit.Test;

import java.io.*;

//练习字节输入流和字节输出流
public class TestOut {
    public static void main(String[] args) {

    }
    //普通字节输出流
    @Test
    public void method1(){
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream("D:\\ready\\test.txt",true);
            fos.write('g');
            fos.write('h');
            fos.write('a');
        }catch(IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //高效字节输出流
    @Test
    public void method2(){
        BufferedOutputStream bos=null;
        try{
            bos=new BufferedOutputStream(new FileOutputStream("D:\\ready\\test.txt"));

        }catch (IOException ex){
            ex.printStackTrace();
        }finally{
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    //普通字符输出流
    public void method3(){
        FileWriter fw=null;
        try{
            fw=new FileWriter("D:\\ready\\test.txt");
            fw.write("我是大的哈比啊对策水电费");
        }catch (IOException ex){
            ex.printStackTrace();
        }finally{
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    //高效字符输出流
    public void method4(){
        BufferedWriter bw=null;
        try{
            bw=new BufferedWriter(new FileWriter("D:\\ready\\test.txt",true));
            bw.write("哈哈哈哈哈哈哈哈");
        }catch (IOException ex){
            ex.printStackTrace();
        }finally{
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
