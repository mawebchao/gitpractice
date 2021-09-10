package cn.tedu.sync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadV3 {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(100);
        TicketR2 tr2=new TicketR2();
        for (int i = 0; i < 5; i++) {
            executorService.execute(tr2);
        }
        executorService.shutdown();
    }
}
class TicketR2 implements Runnable {
    int tickets = 100;
    //创建锁对象
    Object o = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (o) {
                //如果票数>0就卖票
                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "=" + tickets--);
                }
                if (tickets <= 0) break;
            }
        }
    }
}