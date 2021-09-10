package cn.tedu.collection;

import java.io.File;
import java.util.Scanner;

//文件复制案例
public class TestPractice {
    public static void main(String[] args) {
        System.out.println("请输入源文件的路径：");
        String path_s=new Scanner(System.in).next();
        System.out.println("请输入目标文件的路径：");
        String path_t=new Scanner(System.in).next();
        MyUtils.copy(new File(path_s),new File(path_t));
    }
}
