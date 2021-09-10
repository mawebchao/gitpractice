package cn.tedu.io;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class TestFile {

    @Test
    /**
     * 1.创建File文件类对象
     */
    public void method1(){
        File f=new File("D:\\ready\\1.txt");
        //构造函数的参数类型shiString，代表的是要操作的路径
        //  斜杠"/"在文件中有特殊的意义
        //创建文件时，需要设置系统显示的文件的后缀名


    }
    @Test
    //测试文件和文件夹属性
    public void method2(){
        File f=new File("D:\\ready\\1.txt");
        System.out.println(f.length());
        System.out.println("文件是否存在："+f.exists());
        System.out.println("该路径对应的是文件还是文件夹："+(f.isFile()?"文件":"文件夹"));
        System.out.println("上级目录的全路径:"+f.getParent());
        System.out.println(f.getParentFile());
    }
    @Test
    //测试创建也删除
    public void method3() throws IOException {
        //创建文件类对象
        File f=new File("D:\\ready\\2.txt");
        System.out.println(f.createNewFile());
        File f_dir=new File("D:\\ready\\m");
        System.out.println(f_dir.mkdir());
    }
    @Test
    //创建多级文件夹
    public void method4(){
        File f=new File("D:\\ready\\a\\b\\c");
        System.out.println(f.mkdirs());
        f.delete();//只能用来删除文件或者空文件夹
        f=new File("D:\\ready\\a");
        System.out.println(f.delete());
    }
    @Test
    public void method5(){
        File f=new File("D:\\ready");
        System.out.println(Arrays.toString(f.list()));
        System.out.println(Arrays.toString(f.listFiles()));
    }
    @Test
    //普通字节流读取
    public void method6() {
        InputStream fis1=null;
        InputStream fis2=null;
        try{
            //学习子类的创建方式
            //InputStream,OutputStream
            fis1=new FileInputStream(new File("D:\\ready\\1.txt"));
            fis2=new FileInputStream("D:\\ready\\1.txt");
            //read()方法每次调用都会读取
            byte[] bs=new byte[128];
//            System.out.println(fis2.read(bs,0,128));
//            System.out.println(Arrays.toString(bs));
//            fis2.skip(-3);
            int a=-1;
            int length=-1;
            System.out.println(length=fis2.read(bs,0,128));
            System.out.println(length=fis2.read(bs,0,128));
//            while((length=fis2.read(bs,0,128))!=-1){
//
//            }
//            while((a=fis2.read())!=-1){
//                System.out.println(a);
//            }
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                fis1.close();
                fis2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    //高效字节流读取
    public void method7() throws FileNotFoundException {
        //学习子类的创建方式
        //InputStream,OutputStream
        FileInputStream fis=new FileInputStream("D:\\ready\\1.txt");
    }
    //测试缓冲输入流
    @Test
    public void method8(){
        //BufferedInputStream
        //构造方法
        BufferedInputStream bis=null;
        BufferedReader br=null;
        try{
            //1.创建流对象
            bis=new BufferedInputStream(new FileInputStream("D:\\ready\\1.txt"));
            br=new BufferedReader(new FileReader("D:\\ready\\1.txt"));
            //2.使用流对象
            byte[] bs=new byte[128];
            int length=-1;
            while((length=bis.read(bs))!=-1){
                System.out.println(Arrays.toString(bs));
            }
            char[] cs=new char[128];
            length=-1;
            while((length=br.read(cs))!=-1){
                System.out.println(Arrays.toString(cs));
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void method9(){
        char c='d';
        byte b=(byte)c;
        System.out.println(b);
    }
    @Test
    //用于练习字符输入流
    public void method10(){
        BufferedReader br=null;
        BufferedOutputStream bos=null;
        try{
            br=new BufferedReader(new FileReader("D:\\ready\\1.txt"));
            bos=new BufferedOutputStream(new FileOutputStream("D:\\ready\\test.txt"));
            char[] cs=new char[128];
            int length=-1;
            while((length=br.read(cs))!=-1){
                System.out.println(Arrays.toString(cs));
                byte[] bs=new byte[128];
                for (int i = 0; i <cs.length ; i++) {
                    bs[i]=(byte)(cs[i]);
                }
                bos.write(bs);
                System.out.println(Arrays.toString(bs));
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                br.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void method11(){
        BufferedOutputStream bos=null;
        try{
            bos=new BufferedOutputStream(new FileOutputStream("D:\\ready\\test.txt"));
        }catch(IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

