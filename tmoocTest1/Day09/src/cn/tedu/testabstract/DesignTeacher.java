package cn.tedu.testabstract;
//可以总结归纳生活中一类事物的特点，封装成一个“类”
public class DesignTeacher {

}
abstract class Teacher{
    int id;
    String name;
    public abstract void ready();
    public abstract void teach();
}
class CGBTeacher extends  Teacher{

    @Override
    public void ready() {

    }

    @Override
    public void teach() {

    }
}
class ACTTeacher extends  Teacher{

    @Override
    public void ready() {

    }

    @Override
    public void teach() {

    }
}
class SCDTeacher extends  Teacher{

    @Override
    public void ready() {

    }

    @Override
    public void teach() {

    }
}
