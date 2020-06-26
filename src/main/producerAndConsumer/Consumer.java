package producerAndConsumer;

public class Consumer {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }
    public void consum() {
        synchronized (storage) {
            if (this.storage.isEmity()) {
                System.out.println("storage is emity");
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.getStorage().remove(storage.getStorage().size()-1);
            storage.notify();
        }

    }
}
