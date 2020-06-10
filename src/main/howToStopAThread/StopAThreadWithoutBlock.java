package howToStopAThread;

public class StopAThreadWithoutBlock {
    public static void main(String[] args) {
        //print multiples  of 10000  to the max integer/2
        Thread thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num < Integer.MAX_VALUE / 2) {
                num ++;
                if (num % 10000 == 0) {
                    System.out.println("this is :" + num);
                }
            }
            System.out.println("This thread is run over.");
        });
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
