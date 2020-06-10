package howToStopAThread;

public class StopAThreadWithBlock {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= 300) {
                if(num % 100 == 0) {
                    System.out.println("this is " + num);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    // the interrupt status is gone,must reset.
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                num++;
            }

            System.out.println(Thread.currentThread().getName() + ": is run over.");
        });
        thread.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }


}
