package cn.tedu.cn.tedu.annotation;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;


//自定义注解的语法与java不同，不要套用java的格式
//1.定义自定义注解，注解名Rice，并通过两个元注解表示这个自定义注解的作用位置和生命周期
//注解定义的格式：@interface 注解名
//2.通过@Target注解表示此自定义注解可以使用的位置

//注意：我们使用Elementtype.静态常量值的方式，来指定这个自定义注解使用的位置，可以写一个数组，值与值之间用,隔开
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Rice {
    //5.给注解添加属性，增强功能
    //注意：格式为：int age();
    //在自定义注解的时候，可以给属性赋予默认值，格式如default {value}
    int age() default 0;

    //5.自定义注解中可以添加特殊属性value，在添加该自定义注解的时候，可以直接写值
    String value() default "lemon";

}

public class TestAnnotation {
    @Test
    public void method1() throws NoSuchMethodException {
        Class<?> testAnnoClass = TestAnno.class;
        Method method = testAnnoClass.getDeclaredMethod("eat");
        System.out.println(method);
        Rice annotation = method.getAnnotation(Rice.class);
        System.out.println(annotation.value());
    }

    public static void main(String[] args) {

    }

}

class TestAnno {
    String name;

    @Rice("apple")
    public void eat() {
        System.out.println("一会又要干饭了");
    }
}
abstract  class  A{
    public void A(){

    }
}