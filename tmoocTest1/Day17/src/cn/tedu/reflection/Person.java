package cn.tedu.reflection;

//测试暴力反射的物料类
public class Person {
    private String name;
    private int age;
    public String sno;
    //提供私有方法
    private void save(int m, String n) {
        System.out.println("save()" + m + "...." + n);
    }
    private void update(){
        System.out.println("update()...");
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sno='" + sno + '\'' +
                '}';
    }
}
