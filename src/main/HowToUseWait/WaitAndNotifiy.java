package HowToUseWait;

public class WaitAndNotifiy {
   private static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + ":get the lock");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":run over");
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + ":get the lock");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":run over");
            }
        });
        Thread thread3= new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + ":get the lock");
                    object.notifyAll();
                System.out.println(Thread.currentThread().getName() + ":run over");
            }
        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
    }
}
