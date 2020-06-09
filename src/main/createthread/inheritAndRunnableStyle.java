package createthread;

public class inheritAndRunnableStyle {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("I am runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("I am Thread's son");
            }
        }.start();
    }
}
