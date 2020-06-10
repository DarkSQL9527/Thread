package howToCreateAThread;

public class RunnableStyle implements Runnable{

    public void run() {
        System.out.println("runable style");
    }

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }
}
