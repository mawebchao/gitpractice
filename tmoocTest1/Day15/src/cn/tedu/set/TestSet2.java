package cn.tedu.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//本类用于巩固set
public class TestSet2 {
    @Test
    public void method1(){
        HashSet<String> set=new HashSet<>();
        set.add("小白龙");
        set.add("徐汇夏夏");
        set.add("徐汇安小贝");
        System.out.println(set);

        Student s1=new Student("小米1","美丽红",3801.33);
        Student s2=new Student("小米2","美丽红",3801.33);
        Student s3=new Student("小米1","美丽红",3801.33);
        HashSet<Student> s_set=new HashSet<>();
        s_set.add(s1);
        s_set.add(s2);
        s_set.add(s3);
        System.out.println(s_set);
    }
}

class Student{
    String name;
    String color;
    double price;
    public Student(){}
    public Student(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.price, price) == 0 && name.equals(student.name) && color.equals(student.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, price);
    }
}
