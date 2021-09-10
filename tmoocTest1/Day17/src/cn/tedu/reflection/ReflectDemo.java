package cn.tedu.reflection;

import org.junit.Test;

import java.util.Arrays;

public class ReflectDemo {
    @Test
    public void getStudent(){
        Student s1=new Student("张三","32421",123);
        Student s2=new Student("张三","32421",123);
        Student s3=new Student("张三","32421",123);
        Student[] s=new Student[]{s1,s2,s3};
        for (Student stu :
             s) {
            System.out.println(Arrays.toString(Student.class.getMethods()));
        }
    }
}
