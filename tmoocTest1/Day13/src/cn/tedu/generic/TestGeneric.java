package cn.tedu.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGeneric {
    public static void main(String[] args) {
        String[] ss=new String[5];
        ss[0]="泡泡";
        ss[1]="fedsf";
        ss[2]="啊东侧撒";
        ss[3]="gteayg";
        ss[4]="gtr";
        //泛型通常与集合一起使用
        ArrayList<String> list=new ArrayList<String>();
        list.add("fvrdf");
        list.add("fvrdf");
        //泛型的目的就是检查集合中的元素的类型
        Integer[] is=new Integer[]{1,2,3,45};
//        print(is);
        String[] b={"大哥","二哥","三哥","四个","小弟"};
//        print(b);

        Double[] ds=new Double[]{5.6,6.4,4.2};
        print(ds);
        print(new ArrayList<String>(Arrays.asList(ss)));
        print(new ArrayList<Integer>(Arrays.asList(is)));
        print(new ArrayList<Double>(Arrays.asList(ds)));
    }
    private static <E> void print(E[] arr){

    }

    private static <T> void print(List<T> list){
        for (T ele:
             list) {
            System.out.println(ele.toString());
        }
    }
    private static void print(Double[] ds) {
    }

    private static void print(String[] b) {
    }

    private static void print(Integer[] is) {
        for (int i = 0; i < is.length; i++) {
            System.out.println(is[i]);
        }
    }
}
