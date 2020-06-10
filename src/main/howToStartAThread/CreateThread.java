package howToStartAThread;

public class CreateThread {
    public static void main(String[] args) {
        Runnable runnable = ()-> System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.run();
        thread.start();
    }
}
