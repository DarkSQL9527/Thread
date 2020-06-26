package howManyAreThreadState;

public class ThreadState {
    private static  Object object = new Object();
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                synchronized (object) {
                    object.wait();
                    System.out.println("thread run over");

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread thread2 = new Thread(() -> {
            try {
                synchronized (object) {
                    System.out.println("thread run over");
                    Thread.sleep(2000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        System.out.println(thread1.getState());
        thread1.start();
        thread2.start();
        System.out.println(thread1.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
        System.out.println(thread1.getState());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
    }
}
