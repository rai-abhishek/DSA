package dataStructures.queue;

public interface Queue<T> {
    public void offer(T element);
    public T poll();
    public T peak();
    public int size();
    public boolean isEmpty();
}
