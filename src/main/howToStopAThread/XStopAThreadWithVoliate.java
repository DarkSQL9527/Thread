package howToStopAThread;

// you can't user voliate that because  it can't be stoped  when it's blocking.
public class XStopAThreadWithVoliate {
    private static volatile boolean flag = true;
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            int i = 0;
            try {
                while (flag) {
                    Thread.sleep(5000000);
                }
                System.out.println(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //flag =false;
        thread.interrupt();
        System.out.println("flag变为false");
    }
}
