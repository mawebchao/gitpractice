package cn.tedu.oop.oop_final;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestOopFinal {
    //final修饰的class无法被继承
    //final修饰的方法无法被重写
    //final修饰的变量不能被修改


    public static void main(String[] args) {
        Son s =new Son();

    }
}
class Father{
    public final String xing="猪";
    public void work(){
        System.out.println("在车间上班");
    }
}
class Son extends Father{
    @Override
    public void work(){
        System.out.println("在格子间上班");
    }
}