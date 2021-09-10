package cn.tedu.collection;

import java.io.*;
import java.util.Scanner;

public class TestCopyFile {
    public static void main(String[] args) {
        System.out.println("请输入源文件的路径：");
        String path_s=new Scanner(System.in).next();
        System.out.println("请输入目标文件的s路径：");
        String path_t=new Scanner(System.in).next();
        ZJcopy(new File(path_s),new File(path_t));
    }
    public static void ZJcopy(File s, File t){
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;
        try{
            bis=new BufferedInputStream(new FileInputStream(s));
            bos=new BufferedOutputStream(new FileOutputStream(t));
            //流操作
            byte[] bs=new byte[128];
            int length=-1;
            while((length=bis.read(bs))!=-1){
                bos.write(bs);
            }
            System.out.println("文件复制成功");
        }catch (IOException ex){
            System.out.println("文件复制失败");
        }finally{
            try {
                bos.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
            try {
                bis.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
