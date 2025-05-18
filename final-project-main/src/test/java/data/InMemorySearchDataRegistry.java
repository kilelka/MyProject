package data;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class InMemorySearchDataRegistry implements SearchDataRegistry {

    private final Queue<String> availableQueries;


    public InMemorySearchDataRegistry(List<String> initialQueries) {
        this.availableQueries = new ConcurrentLinkedQueue<>(initialQueries);
    }

    @Override
    public synchronized String next() {
        if (!hasNext()) {
            throw new IllegalStateException("Данные закончились");
        }
        return availableQueries.poll();
    }

    @Override
    public synchronized boolean hasNext() {
        return !availableQueries.isEmpty();
    }

}
