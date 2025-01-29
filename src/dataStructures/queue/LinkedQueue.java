package dataStructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<T> implements Queue<T>,Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    public LinkedQueue() {}

    public LinkedQueue(T firstElement) {
        offer(firstElement);
    }

    @Override
    public void offer(T element) {
        list.addLast(element);
    }

    @Override
    public T poll() {
        return list.removeFirst();
    }

    @Override
    public T peak() {
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return "LinkedQueue{" +
                "list=" + list +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {
        LinkedQueue<String> qq = new LinkedQueue<>();
        qq.offer("A");
        qq.offer("b");
        qq.offer("c");
        qq.offer("D");
        qq.offer("P");
        qq.offer("Q");
        qq.offer("Z");
        qq.offer("D");
        System.out.println(qq);

        System.out.println("Dequeue: " + qq.poll());
        System.out.println(qq);
        System.out.println("Peak: " + qq.peak());
        qq.offer("10");
        System.out.println(qq);
    }
}
