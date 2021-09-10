package cn.tedu.review;

import java.io.*;

public class TestSerializable {
    public static void main(String[] args) {
        method2();
        method1();
    }

    private static void method2() {
        ObjectOutputStream oos=null;
        try{
            oos=new ObjectOutputStream(new FileOutputStream("D:\\ready\\test1.txt"));
            Student s=new Student("小马","1011");
            oos.writeObject(s);
        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method1(){
        ObjectInputStream ois=null;
        try{
            FileInputStream fis=new FileInputStream("D:\\ready\\test1.txt");
            System.out.println(fis);
            ois=new ObjectInputStream(fis);
            Student s=(Student) ois.readObject();
            System.out.println(s);
        }catch (IOException | ClassNotFoundException ex){
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
class Student implements  Serializable{
    String name;
    String sno;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                '}';
    }

    public Student(String name, String sno) {
        this.name = name;
        this.sno = sno;
    }
}
