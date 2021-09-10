package cn.tedu.Review;

public class ReviewObject {
    public static void main(String[] args) {
        Student s1=new Student("派大星","手机");
        Student s2=new Student("派大星","手机");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

    }
}
