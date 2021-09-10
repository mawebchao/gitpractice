package cn.tedu.testabstract;
/*
本类用于面向接口编程之设计老师案例
接口时先天的设计的结果
 */
public class DesignTeacher2 {
    public static void main(String[] args) {
        CGBTeacher2 cgb2=new CGBTeacher2();
        ACTTeacher2 act2=new ACTTeacher2();
        cgb2.teach();
        act2.teach();
    }
}
interface Teacher2{
    //接口定义的是规则
    void ready();
    void teach();
}
class CGBTeacher2 implements Teacher2{

    @Override
    public void ready() {
        System.out.println("CGB老师正在备课");
    }

    @Override
    public void teach() {
        System.out.println("CGB老师正在授课");
    }
}
class ACTTeacher2 implements Teacher2{
    @Override
    public void ready() {
        System.out.println("ACT老师正在备课");
    }

    @Override
    public void teach() {
        System.out.println("ACT老师正在授课");
    }
}