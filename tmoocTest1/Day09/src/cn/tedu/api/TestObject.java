package cn.tedu.api;

import java.util.Objects;

public class TestObject {
    public static void main(String[] args) {
        Student stu1=new Student("小朱",3);;
        Student stu2=new Student("小猪",3);
        System.out.println(stu1);
        System.out.println(stu2);
        //可以大致理解为不同对象的hashcode值就是不一样的
        System.out.println(stu1.hashCode());
        System.out.println(stu2.hashCode());
        System.out.println("stu1和stu2是否相等："+stu1.equals(stu2));
    }
}
class Student{
    String name;
    int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && (Objects.equals(name, student.name)||(student.name.equals("小猪")&&name.equals("小朱")));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
