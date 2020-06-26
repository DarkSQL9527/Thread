package producerAndConsumer;

public class Test {

    public static void main(String[] args) {
        Storage storage = new Storage(10);
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        Thread producerThread = new Thread(() -> {
            while (true) {
                producer.product();
                System.out.println("producer product a number");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread consumerThread = new Thread(() -> {
            while (true) {
                consumer.consum();
                System.out.println("consumer consum a number");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        producerThread.start();
        consumerThread.start();
    }
}
