package cn.tedu.oop.oop_extends;

public class TestExtends2 {
    public static void main(String[] args) {
        //子类构造函数的第一行默认存在super()--表示调用父类的无参构造
        Father2 f2=new Father2("屎");
        Son2 s2=new Son2();
    }
}
class Father2{
    public Father2(String s){
        System.out.println("爸爸爱吃"+s);
    }
}
class Son2 extends Father2{
    public Son2(){
        super("屎");
        System.out.println("我是Son2类的无参构造");
    }
}
