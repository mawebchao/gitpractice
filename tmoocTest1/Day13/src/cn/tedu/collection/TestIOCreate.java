package cn.tedu.collection;

import java.io.*;

public class TestIOCreate {
    public static void main(String[] args) {
        String pathName="D:\\ready\\test.txt";
        FileInputStream fis=null;
        BufferedInputStream bis;
        FileOutputStream fos=null;
        BufferedOutputStream bos=null;
        FileReader fr=null;
        BufferedReader br=null;
        FileWriter fw= null;
        BufferedWriter bw=null;
        try{
            /*字节输入流*/
            fis=new FileInputStream(pathName);
            bis=new BufferedInputStream(fis);
            /*字节输出流*/
            fos=new FileOutputStream(pathName);
            bos=new BufferedOutputStream(fos);
            /*字符输入流*/
            fr=new FileReader(pathName);
            br=new BufferedReader(fr);
            /*字符输出流0*/
            fw=new FileWriter(pathName);
            bw=new BufferedWriter(fw);
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {

        }

    }
}
