package cn.tedu.serializable;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import jdk.nashorn.internal.parser.JSONParser;
import sun.plugin.javascript.JSObject;

import java.io.*;
import java.util.Arrays;

//序列化与反序列化
//objectoutputstream（序列化流）
//objectinputstream（反序列化流）
//序列化与反序列化都是由流来完成的
//如果一个类需要被序列化，那么这个类必须实现可序列化接口
public class TestSerial {
    public static void main(String[] args) {
        //写object
//        method1();
        //读Object
        method2();
    }
    public static void method1(){

        Student s1=new Student("大傻逼",20,"上海市",'男');
        Student s2=new Student("大傻逼",10,"上海市",'男');
        Student s3=new Student("大傻逼",20,"上海市",'5');
        Student s4=new Student("大傻逼",20,"上海市",'2');
        Student s5=new Student("大傻逼",50,"上海市",'2');

        Student[] ss=new Student[]{s1,s2,s3,s4,s5};
        ObjectOutputStream osw=null;
        try{
            osw=new ObjectOutputStream(new FileOutputStream("D:\\ready\\test1.txt"));
            osw.writeObject(s1);
            System.out.println("Student写入成功");
        }catch (IOException ex){
            System.out.println("Student对象写入失败");
            ex.printStackTrace();
        }finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void method2(){
        Student str=null;
        ObjectInputStream ois=null;
        try{
            ois=new ObjectInputStream(new FileInputStream("D:\\ready\\test1.txt"));
            str=(Student) (ois.readObject());
            System.out.println(JSONParser.quote(String.valueOf(str)));
            System.out.println(str);
//            Student[] ss=String.
        }catch (IOException | ClassNotFoundException ex){
            System.out.println("Student对象读取失败");
            ex.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
//Serializable是一个空接口
//作用是当作标志，标志这个类可以被序列化，相当于打一个标记
class Student implements Serializable {
    private String dasda;
    private String name;
    private int age;
    private String addr;
    private char gender;

//    private static final long serialVersionUID=1L;
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Student(String name, int age, String addr, char gender) {
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
