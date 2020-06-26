package TreadPool;

import java.util.List;
import java.util.concurrent.*;

public class CreateThreadPool {

    public static void main(String[] args) {
       // ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = new ThreadPoolExecutor(5, 8,
//                0L, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(5));
        ExecutorService executorService =  new PauseThreadPool(5,8,60,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for(int i=0 ;i < 1000;i++) {
            executorService.execute(new Task());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       ((PauseThreadPool) executorService).pause();
        System.out.println("线程池暂停了");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((PauseThreadPool) executorService).resume();
        System.out.println("线程池恢复了");
    }
    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
