package dataStructures.queue;

public class IntQueue implements Queue<Integer> {
    private int[] data;
    private int front, rear;
    private int size;

    public IntQueue(int maxSize) {
        front = rear = size = 0;
        data = new int[maxSize];
    }

    @Override
    public void offer(Integer element) {
        if(isFull()) throw new RuntimeException("Queue is full");
        data[rear++] = element;
        size++;
        rear = rear % data.length;
    }

    @Override
    public Integer poll() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        size--;
        front = front % data.length;
        return data[front++];
    }

    @Override
    public Integer peak() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
