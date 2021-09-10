package cn.tedu.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect2 {
    @Test
    public void method1() throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> personClass=Person.class;
        Constructor<?>[] personClassDeclaredConstructors=personClass.getDeclaredConstructors();
        Field f=personClass.getDeclaredField("name");
        System.out.println(f.getDeclaringClass());
        Person p=(Person) personClass.newInstance();
        Method setName_method=p.getClass().getDeclaredMethod("setName",String.class);
        setName_method.invoke(p,"dfg");
        System.out.println(p);
        f.set(p,"sdf");
        System.out.println(p);
        System.out.println("***************");
        Object obj=personClass.newInstance();
        f.setAccessible(true);
        //通过属性对象给指定对象obj设置一个值
        f.set(obj,"派大星");
        System.out.println((Person)obj);
        System.out.println(f.get(obj));
        //修改field的权限
        //暴力反射需要设置权限私有可见
    }
    //练习与获取私有方法
    @Test
    public void method2() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method method=Person.class.getDeclaredMethod("save",int.class,String.class);
        Person p=Person.class.newInstance();
//        method.setAccessible(true);
        method.invoke(p,12,"gvdf");
        System.out.println(p);
    }
}
