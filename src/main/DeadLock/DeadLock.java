package DeadLock;

import java.util.HashMap;

public class DeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    System.out.println(Thread.currentThread().getName() + "get the lock1");
                    Thread.sleep(1000);
                    new HashMap<>();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("let lock2");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "get the lock2");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("let lock1");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
