package AboutDanger;

public class OutOfOrder {
    private static int x,y;
    private static int a,b;

    public static void main(String[] args) {
        while (true) {
            x= 0;
            y =0;
            a = 0;
            b = 0;
            Thread thread1 = new Thread(() -> {
               a = 1;
               if(a==1) {
                   System.out.println("1");
               }
            });
            Thread thread2 = new Thread(() -> {
               b = a;
            });
            thread1.start();
            thread2.start();
            try {
                //x=0;y=1
                //x=1;y=0
                //x=1;y=1
                thread1.join();
                thread2.join();
                System.out.println("x=" + x + "y=" + y + "a=" + a + "b=" + b);
                if(x == 0 && y==0) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
