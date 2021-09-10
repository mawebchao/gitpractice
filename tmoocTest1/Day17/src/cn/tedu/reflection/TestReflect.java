package cn.tedu.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflect {
    //
    @Test
    public void getConstructor() throws NoSuchMethodException {
        Class<?> studentClass=Student.class;
        Constructor<?>[] constructors = studentClass.getConstructors();
        System.out.println(Arrays.toString(studentClass.getConstructors()));
        for (Constructor cons:
             constructors) {
            System.out.println(cons.getName());
            Class<?>[] parameterTypes=cons.getParameterTypes();
            System.out.println(Arrays.toString(parameterTypes));
        }
    }
    @Test
    public void method1() throws ClassNotFoundException {
        Class<?> studentClass = Student.class;
        System.out.println(Class.forName("cn.tedu.reflection.Student"));
        System.out.println(Student.class);
//        System.out.println(new Student("gerdsf","frd",12).getClass());
//        System.out.println(new Student("fd","gverdf",12).getClass().getPackage());
    }
    //获取指定类Student的成员方法
    @Test
    public void methdo2(){
        //获取字节码对象
        Class<?> studentClass=Student.class;
        //获取成员方法
        Method[] methods = studentClass.getMethods();
        for (Method m:
             methods) {
            System.out.println(m.getName());
            System.out.println(Arrays.toString(m.getParameterTypes()));
            System.out.println(Arrays.toString(m.getParameterTypes()).contains(String.class.toString())?"包含String成员变量":"不包含String成员变狼");
        }
    }
    //用于获取指定的类的成员变量
    @Test
    public void method3(){
        //获取字节码对象
        Class<?> studentClass=Student.class;
        //获取成员方法
        Field[] fields1 = studentClass.getDeclaredFields();
        //public变量
        Field[] fields = studentClass.getFields();
        for (Field f:
                fields1) {
            System.out.println(f.getName());
            System.out.println(f.getType().getName());
        }
        System.out.println("****************getName*******************");
        for (Field f:
                fields) {
            System.out.println(f.getName());
            System.out.println(f.getType().getName());
        }
    }
    @Test
    public void method4(){
        Constructor<?>[] constructors=Student.class.getDeclaredConstructors();
        for (Constructor f:
                constructors) {
            System.out.println(f.getName());
        }
        Method[] methods=Student.class.getDeclaredMethods();
        for (Method f:
                methods) {
            System.out.println(f.getName());
        }
        Field[] fields=Student.class.getDeclaredFields();
        for (Field f:
                fields) {
            System.out.println(f.getName());
            System.out.println(f.getType().getName());
        }
        System.out.println(Arrays.toString(constructors));
        System.out.println(Arrays.toString(methods));
        System.out.println(Arrays.toString(fields));
    }
    //通过反射来创建指定类的对象
    @Test
    public void method5() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> studentClass=Student.class;
        Object o = studentClass.newInstance();
        System.out.println(o);
        //如果需要出发其他的构造函数来构造对象的话，需要先获取指定的构造函数对象
        //想尝试通过其他的构造方法来构造对象
        Constructor<?> constructor = studentClass.getConstructor(String.class,String.class,int.class);
        System.out.println(constructor.getName());
        System.out.println(Arrays.toString(constructor.getParameterTypes()));
        Student o1 = (Student) constructor.newInstance("ads", "Fsd", 12);
        System.out.println(o1);
        o1.setName("asdecsd");
        System.out.println(o1.getClass());
        System.out.println(o1);
        Object o2= (Student) constructor.newInstance("ads", "Fsd", 92);
    }
}
