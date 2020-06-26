package AboutDanger;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedNum {
    private static int a = 0;
    private static boolean[] check = new boolean[1000000];
    private static  Object lock = new Object();
    private static AtomicInteger errorCount = new AtomicInteger();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i=0; i< 100000;i++) {
               int index = ++a;

                synchronized (lock) {
                   if(check[index]) {
                       System.err.println("error happend num is " + index);
                       errorCount.incrementAndGet();
                   }else {
                       check[index] = true;
                   }
               }

                System.out.println(a);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i=0; i< 100000;i++) {
                int index = ++a;

                synchronized (lock) {
                    if(check[index]) {
                        System.err.println("error happend num is " + index);
                        errorCount.incrementAndGet();
                    }else {
                        check[index] = true;
                    }
                }
                System.out.println(a);
            }
        });
        Thread thread3= new Thread(() -> {
            for (int i=0; i< 100000;i++) {
                int index = ++a;

                synchronized (lock) {
                    if(check[index]) {
                        System.err.println("error happend num is " + index);
                        errorCount.incrementAndGet();
                    }else {
                        check[index] = true;
                    }
                }
                System.out.println(a);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main:" + a);
        System.out.println("error count num is " + errorCount.get());
    }
}
