package producerAndConsumer;

public class Producer {
    public  final  Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public  void product() {
        synchronized (storage) {
            if (storage.isFull()) {
                try {
                    System.out.println("storage is full");
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.getStorage().add((int) Math.random()*100);
            storage.notify();
        }

    }
}
