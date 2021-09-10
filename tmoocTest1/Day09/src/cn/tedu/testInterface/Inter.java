package cn.tedu.testInterface;

public interface Inter {
    //接口中不可以有普通方法
    //接口中的方法全部都是抽象方法
    //接口中不存在变量，而是静态常量，会默认拼接staic与final，值不可以被修改
    //接口中方法的定义可以简写，会自动拼接public和abstract
    public abstract void eat();
    public abstract void play();
}
