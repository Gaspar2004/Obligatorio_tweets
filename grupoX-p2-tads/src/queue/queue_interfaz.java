package queue;

public interface queue_interfaz<T> {
    void enqueue(T value);
    T dequeue() throws EmptyQueueException;
    boolean contains(T value);

    int size();
}
