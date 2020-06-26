package threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocal1 {
    private  static  SimpleDateFormat  dateFormat = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
    public String date(int time) {
        Date date = new Date(time * 1000);
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i < 1000;i++) {
            int time = i;
            executorService.submit(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new ThreadLocal1().date(time));
            });
        }

    }
}
