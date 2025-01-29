package dataStructures.stack;

import java.util.Arrays;
import java.util.Iterator;

public class IntStack implements Stack<Integer> {

    private int[] ar;
    private int pos = 0;

    //maxSize is the maximum number of items that can be in a queue at any given time
    public IntStack(int maxSize) {
        ar = new int[maxSize];
    }

    @Override
    public int size() {
        return pos;
    }

    @Override
    public boolean isEmpty() {
        return pos == 0;
    }

    @Override
    public Integer peek() {
        return ar[pos -1];
    }

    @Override
    public void push(Integer elem) {
        ar[pos++] = elem;
    }

    @Override
    public Integer pop() {
        return ar[--pos];
    }

    @Override
    public String toString() {
        return "IntStack{" +
                "ar=" + Arrays.toString(ar) +
                ", pos=" + pos +
                '}';
    }

    public static void main(String[] args) {
        IntStack s =  new IntStack(6);
        s.push(1);
        s.push(2);
        s.push(7);
        s.push(4);
        s.push(5);
        s.push(-1);
        System.out.println(s);

        System.out.println("pop the record: " + s.pop());
        System.out.println("pop the record: " + s.pop());
    }

}
