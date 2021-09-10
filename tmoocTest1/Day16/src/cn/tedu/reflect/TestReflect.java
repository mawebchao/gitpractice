package cn.tedu.reflect;
import org.junit.Test;
//本来用于测试反射的物料类，假装是别人写的类
public class TestReflect {
    @Test
    public void getClazz(){
        try {
            Class<?> clazz1=Class.forName("cn.tedu.reflect.Student");
            Class<?> clazz2=Student.class;
            Class<?> clazz3=new Student().getClass();
            System.out.println(clazz1);
            System.out.println(Class.forName("cn.tedu.reflect.Student"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
    public void eat(){
        System.out.println("饿了就吃个火锅吧");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

