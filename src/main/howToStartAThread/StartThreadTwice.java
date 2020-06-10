package howToStartAThread;

public class StartThreadTwice {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("start"));
        thread.start();
        thread.start();
    }
}
