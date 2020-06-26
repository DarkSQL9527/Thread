package DeadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class TransferMoney {
    static  ArrayList<Person> persons = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {

        for (int i =0 ; i< 20;i++) {
            persons.add(new Person(getName(),500.00));
        }
        Thread[] threads = new Thread[5000];
        for (int i =0 ; i< threads.length;i++) {
            Thread thread = new Thread(() -> {

                    int index = new Random().nextInt(20);
                    int index2 = new Random().nextInt(20);
                    TransferMoney.transfer(persons.get(index), persons.get(index2), 200);


            });
            threads[i] = thread;
        }
        for (Thread thread:threads) {
            thread.start();
        }

//        Thread checkdead = new Thread(() -> {
//            while (true) {
//                ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//                long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
//                if(deadlockedThreads!= null && deadlockedThreads.length > 0) {
//                    for(int i=0;i< deadlockedThreads.length;i++) {
//                        ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
//                        System.out.println("发生死锁" + threadInfo.getThreadName());
//                    }
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        });
      //  checkdead.setDaemon(true);
        //checkdead.start();
        for (Thread thread:threads) {
            thread.join();
        }
        int total = 0;
        for(int i=0 ;i < 20;i++) {
            System.out.println(persons.get(i).getName() + "'s money is:" + persons.get(i).getMoney());
            total += persons.get(i).getMoney();
        }
        System.out.println("total:" + total);

      //  System.out.println("tom's money is:" + tom.getMoney());
    }
    public static void transfer(Person from ,Person to,double money) {
        int fromHash = from.hashCode();
        int toHash = to.hashCode();
        if(fromHash < toHash) {
            synchronized (from) {
                synchronized (to) {
                    transferMoney(from,to,money);
                }

            }
        }else if(fromHash > toHash) {
            synchronized (to) {
                synchronized (from) {
                    transferMoney(from,to,money);
                }

            }
        }else {
            synchronized (TransferMoney.class) {
                transferMoney(from,to,money);
            }
        }


    }

    private static void transferMoney(Person from ,Person to,double money) {
        if(from.getMoney() - money < 0) {
            System.out.println("Sorry " + from.getName() +" Current money is not enough to tranfer");
            return;
        }
        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);
    }

    public static  String getName() {
            String str="abcdefghijklmnopqrstuvwxyz";
            Random random=new Random();
            StringBuffer sb=new StringBuffer();
            for(int i=0;i < 4;i++){
                int number=random.nextInt(26);
                sb.append(str.charAt(number));
            }
            return sb.toString();
    }
}
