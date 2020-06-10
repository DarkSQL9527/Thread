package howToCreateAThread;

public class InheritStyle extends Thread{
    @Override
    public void run() {
        System.out.println("inherit Style");
    }

    public static void main(String[] args) {
        new InheritStyle().start();
    }
}
