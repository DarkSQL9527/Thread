package join;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("thread1 is run over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("thread2 is run over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
            System.out.println("main is run over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
