package cn.tedu.thread;

public class TestThread2 {
    public static void main(String[] args) {
        //创建目标业务对象，目标业务对象只需要创建一次
        //需要将目标业务对象target与线程类建立关系，只有建立了关系，才能使用线程类的start方法，以多线程的方式启动线程
        MyThread2 thread1=new MyThread2();
        Thread t1=new Thread(thread1);
        t1.start();
        Thread t2=new Thread(thread1);
        t2.start();
        Thread t=new Thread();
        t.start();
    }
}

class MyThread2 implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}