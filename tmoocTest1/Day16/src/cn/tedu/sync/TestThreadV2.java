package cn.tedu.sync;

public class TestThreadV2 {
    public static void main(String[] args) {
        MyThreadV2 t1 = new MyThreadV2("黄牛1");
        t1.start();
        MyThreadV2 t2 = new MyThreadV2("黄牛2");
        t2.start();
        MyThreadV2 t3 = new MyThreadV2("黄牛3");
        t3.start();
        MyThreadV2 t4 = new MyThreadV2("黄牛4");
        t4.start();
        System.out.println(MyThreadV2.class);
    }
}

class MyThreadV2 extends Thread {
    static int tickets = 1;

    public MyThreadV2(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (tickets<100) {
            //字节码对象

            synchronized (MyThreadV2.class) {
                if (tickets <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "抢到了第" + (tickets++) + "张票");
                } else {
                    break;
                }
            }

        }
    }
}