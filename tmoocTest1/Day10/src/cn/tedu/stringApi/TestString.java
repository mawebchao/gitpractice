package cn.tedu.stringApi;

public class TestString {
    public static void main(String[] args) {
        //创建string的方式一
        char[] cArr=new char[]{'a','b','c'};
        String s1=new String(cArr);
        String s11=new String(cArr);
        //创建String的方式二
        String s2="abc";
        String s22="abc";
        String s3="ccc";
        System.out.println("s1==s11:"+(s1==s11));
        System.out.println("s22==s2:"+(s22==s2));
        System.out.println("s1==s2:"+(s1==s2));
        System.out.println("s3==s2:"+(s3==s2));

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s11));
        System.out.println(s2.equals(s3));
        //String重写了equals方法，重写后，不再使用==的地址值比较，而且是比较两个String的内容
    }
}

