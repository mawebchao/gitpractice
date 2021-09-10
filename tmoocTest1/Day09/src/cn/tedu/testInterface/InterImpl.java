package cn.tedu.testInterface;

public class InterImpl implements Inter{
    @Override
    public void eat() {
        System.out.println("正在吃");
    }

    @Override
    public void play() {
        System.out.println("正在玩");
    }
}
