package dataStructures.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private int size;
    private int capacity;
    private Object[] data;

    public ArrayStack() {
        capacity = 16;
        data = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T elem) {
        if(size == capacity) increaseCapacity();
        data[size++] = elem;
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        return (T) data[--size];
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new EmptyStackException();
        return (T) data[size -1];
    }

    private void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data,capacity);
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public static void main(String[] args) {
        ArrayStack<String> str = new ArrayStack<>();

        str.push("10");
        str.push("C");
        str.push("H");
        System.out.println(str);

        System.out.println("pop: " + str.pop());

    }
}
