package cn.tedu.thread;

import org.junit.Test;

public class TestThread1 {
    public static void main(String[] args) {
        MyThread myThread1=new MyThread("Thread1");
        MyThread myThread2=new MyThread("Thread2");
        //start对应的是线程的就绪状态，至于什么时候执行，取决于什么时候被操作系统选中
        //当我们调用start方法启动线程时，底层虚拟机会自动调用run方法
        myThread1.start();
        myThread2.start();
    }
}
//方式一：继承线程
class MyThread extends Thread{
    public MyThread(){}
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
//        super.run();
        /*自定义线程类的业务需要写在重写的run方法里*/
        /*super.run()表示调用的是父类的业务，我们不用，所以注释掉*/
        //写自己的业务：输出10次当前正在执行的线程的名称
        for (int i = 0; i <10 ; i++) {
            //getName方法表示可以获取当前正在执行的线程名称，由于本类继承了Thread类，
            // 所以可以直接使用这个方法
            System.out.println(this.getName());
        }
    }

}