package AboutException;
//use the uncaughtException to capture all thread exception
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("i'm dead");
        });
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("i'm dead");
        });
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("i'm dead");
        });
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtException());
        thread1.start();
        thread2.start();
        thread3.start();
        for (int i=0 ;i < 100 ;i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
