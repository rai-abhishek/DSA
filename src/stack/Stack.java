package stack;

import java.util.Arrays;

public class Stack {
    int[] ar = new int[20];
    int tos = -1; //top of stack
    int size = 0;

    public void push(int x) {
        if(tos == ar.length) {
            System.out.println("Stack Overflow");
        }
        tos++;
        ar[tos] = x;
        size++;
    }

    public int top() {
        if(tos == -1) {
            System.out.println("Stack underflow");
        }
        return ar[tos];
    }

    public int pop() {
        if(tos == -1) {
            System.out.println("Stack underflow");
        };
        int element = ar[tos];
        tos--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        int index = 0;
        while(index <= tos) {
            System.out.print(ar[index] + " ");
            index++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
        System.out.println(s.size());
        s.print();
        System.out.println(s.isEmpty());
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.print();
        s.size();
    }
}
