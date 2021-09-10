package cn.tedu.Review;

import java.util.Objects;

public class Review {
    public static void main(String[] args) {
        Student s1=new Student("PDX","爷爷的老年手机");
        System.out.println(s1);
        System.out.println(s1.toString());
    }
}

class Student{
    private String sno;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sno, student.sno) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Student(String sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    private String name;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
