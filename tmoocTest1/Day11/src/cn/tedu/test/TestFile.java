package cn.tedu.test;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {
        File f_txt=new File("D:\\s.txt");
        System.out.println("f_txt的创建结果为："+f_txt.createNewFile());
        File f_nosuffix=new File("D:\\hhh_nosuffix");
        System.out.println("f_nosuffix的创建结果为："+f_nosuffix.createNewFile());
        //创建一个文件夹
        File f_dir=new File("D:test_dir");
    }
}
//1.创建File文件对象
/*1.构造函数的参数是String类型的pathname(路径名)
 * 这个路径可以是文件路径,也可以是文件夹路径*/
/*2.\在代码中有特殊的意义,所以想要真正表示这是一个\,需要用\进行转义*/
//注意:此处需要自己手动在D盘创建对应目录下的1.txt,并添加内容
//注意:创建1.txt时,需要设置系统显示文件后缀名,如果没设置,文件名应该是1
//注意:File需要导包:import java.io.File;
