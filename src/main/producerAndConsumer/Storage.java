package producerAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private int maxSize;
    private List<Integer> storage;

    public Storage(int maxSize) {
        this.maxSize = maxSize;
        storage = new ArrayList(maxSize);
    }

    public List<Integer> getStorage() {
        return storage;
    }

    public void setSorage(List sorage) {
        this.storage = sorage;
    }
    public synchronized  boolean isFull() {
        return this.maxSize == storage.size() ? true:false;
    }
    public synchronized boolean isEmity() {
        return 0 == storage.size() ? true:false;
    }
}
