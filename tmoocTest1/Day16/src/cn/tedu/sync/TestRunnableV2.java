package cn.tedu.sync;
//本类用于改造多线程售票案例。解决售票安全问题
//锁的范围不能太大也不能太小

public class TestRunnableV2 {
    //synchronized关键字
    public static void main(String[] args) {
        MyThread3 target = new MyThread3();
        Thread t1 = new Thread(target, "黄牛1");
        Thread t2 = new Thread(target, "黄牛2");
        Thread t3 = new Thread(target, "黄牛3");
        Thread t4 = new Thread(target, "黄牛4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class MyThread3 implements Runnable {
    int tickets = 100;

    @Override
    public void run() {
        while (true) {
            //锁对象必须唯一，所以这里必须要使用的同一个对象
            synchronized (this) {
                if(tickets>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了第" + (tickets--) + "张票");
                }else{
                    break;
                }

            }
        }
    }
}
