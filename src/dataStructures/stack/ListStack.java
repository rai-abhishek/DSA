package dataStructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class ListStack<T> implements Iterable<T>,Stack<T> {
    private LinkedList<T> list = new LinkedList<>();

    //create an empty stack
    public ListStack() {}

    //create a stack with an initial element
    public ListStack(T firstElement) {
        push(firstElement);
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
    public void push(T elem) {
        list.addLast(elem);
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new EmptyStackException();
        return list.peekFirst();
    }

    public int search(T elem) {
        return list.lastIndexOf(elem);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {
        ListStack<Integer> intStack = new ListStack<>();
        intStack.push(10);
        intStack.push(0);
        intStack.push(15);
        intStack.push(2);
        intStack.push(19);
        intStack.push(7);
        intStack.push(12);
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);
        intStack.pop();
        System.out.println(intStack);
        System.out.println("Index of element 15 in Stack is: " + intStack.search(15));
    }
}
