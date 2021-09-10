package cn.tedu.review;

public class Student {
    private char d;
    double c;
    public String a;
    private int b;

    public char getD() {
        return d;
    }

    public Student(){}
    public Student(char d, double c, String a, int b) {
        this.d = d;
        this.c = c;
        this.a = a;
        this.b = b;
    }

    public void setD(char d) {
        this.d = d;
    }
    public void study(String name,int num){
        System.out.println(name+"今天要写"+num+"行代码");
    }

    @Override
    public String toString() {
        return "Student{" +
                "d=" + d +
                ", c=" + c +
                ", a='" + a + '\'' +
                ", b=" + b +
                '}';
    }
    private void sleep(){
        System.out.println("大家可以休息一下");
    }
}
