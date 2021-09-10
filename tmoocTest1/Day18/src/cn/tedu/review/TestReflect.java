package cn.tedu.review;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//回顾反射API
public class TestReflect {
    @Test
    public void getClazz() throws ClassNotFoundException {
        Class<?> aClass=Class.forName("cn.tedu.review.Student");
        Class<?> bClass=Student.class;
        //泛型的上下限
        Class<? extends Student> cClass=new Student().getClass();
        System.out.println(aClass);
        System.out.println(bClass);
        System.out.println(cClass);
    }
    @Test
    public void getCons() throws NoSuchMethodException {
        Class<?> bClass=Student.class;
        Constructor constructor=bClass.getConstructor(char.class, double.class, String.class, int.class);
        Constructor<?>[] constructors= bClass.getConstructors();
        for (Constructor con:
             constructors) {
            System.out.println(con);
            System.out.println(con.getParameterTypes());
        }
    }
    @Test
    public void getMethods() throws NoSuchMethodException {
        Class<?> bClass=Student.class;
        Method[] methods=bClass.getMethods();
        for (Method method:
                methods) {
            System.out.println(method);
            System.out.println(method.getParameterTypes());
        }
    }
    @Test
    public void getFields() {
        Class<?> bClass=Student.class;
        Field[] methods=bClass.getFields();
        for (Field field:
                methods) {
            System.out.println(field);
            System.out.println(field.getName());
        }
    }
    @Test
    public void create() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Student student=Student.class.newInstance();
        System.out.println(student);
        Constructor<?> constructor=Student.class.getConstructor(char.class, double.class, String.class, int.class);
        Student stu=(Student) constructor.newInstance('a',48.2,"Gtf",4);
        System.out.println(stu);
        stu.study("df",3243);
    }
    @Test
    public void getPriFie() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Student student=Student.class.newInstance();
        Field d = Student.class.getDeclaredField("d");
        System.out.println(d);
        System.out.println(d.getType());
        d.setAccessible(true);
        System.out.println(student.getD());
        d.set(student,'女');
        System.out.println(student.getD());
    }
    @Test
    public void getPriFunc() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj=Student.class.newInstance();
        Method priMethod=Student.class.getDeclaredMethod("sleep");
        priMethod.setAccessible(true);
        priMethod.invoke(obj);
    }
}
