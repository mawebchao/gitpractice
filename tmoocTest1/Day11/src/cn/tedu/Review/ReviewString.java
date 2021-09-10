package cn.tedu.Review;

public class ReviewString {
    public static void main(String[] args) {
        String s="abc";
        System.out.println(s);
        String s1="abc";
        char[] charArr=new char[]{'a','b','c'};
        String s2=new String(charArr);
        System.out.println(s==s1);
        System.out.println(s.equals(s1));
        System.out.println(s==s2);
        System.out.println(s.equals(s2));
    }
}
