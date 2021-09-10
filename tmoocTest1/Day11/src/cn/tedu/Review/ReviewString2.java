package cn.tedu.Review;

public class ReviewString2 {
    public static void main(String[] args) {
        String s1="abcde";
        System.out.println(s1.charAt(2));
        System.out.println(s1.concat("bbb"));
        System.out.println(s1.startsWith("a"));
        System.out.println(s1.endsWith("e"));

        String f="abfsdbbb";
        System.out.println(f.indexOf("b"));
        System.out.println(f.lastIndexOf("e"));

        System.out.println(f.toUpperCase());
        System.out.println(f.toLowerCase());

        String s2="abcafsdf";
        System.out.println(s2.split("b"));

        System.out.println(String.valueOf("10")+10);

        String hhh="abcdefg";
        System.out.println(hhh.substring(4));
        System.out.println(hhh.substring(4,7));
    }
}

