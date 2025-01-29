package dataStructures.dynamicArrays;

import java.util.Arrays;
import java.util.Iterator;

/**
 * This file contains an implementation of an integer only array
 * which can outperform Java's ArrayList by about a factor of 10-15x! Enjoy!
 */
public class IntArray implements Iterable<Integer> {

    // declare variables
    private static final int DEFAULT_CAP = 1 << 3;
    private int[] arr;
    private int len = 0;
    private int capacity = 0;

    //Initialize the array

    //Default capacity
    public IntArray() {
        this(DEFAULT_CAP);
    }
    // with certain capacity
    public IntArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }
    //given an array, make it a dynamic array
    public IntArray(int[] array) {
        arr = Arrays.copyOf(array,array.length);
        capacity = len = array.length;
    }
    // Implement Methods

    // size
    public int size() {
        return len;
    }
    // isEmpty
    public boolean isEmpty() {
        return len == 0;
    }
    //get / set
    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int element) {
        arr[index] = element;
    }

    // add an element to dynamic array

    /**
     * Check if the array capacity has exhausted (len + 1 > capacity)
     * if yes then double the size of array
     */
    public void add(int element) {
        if (len + 1 > capacity) {
            if (capacity == 0 ) capacity = 1;
            else capacity *= 2;
            arr = Arrays.copyOf(arr,capacity);
        }
        arr[len++] = element;
    }

    // remove the element at a specific index

    /**
     * create a new array.
     * maintain two pointers i & j.
     * if data at i == remove data , then skip it. else copy each value at index from old (i) to new array (j)
     * copy new array to old array.
     */
    public int removeAt(int rm_index) {
        if(rm_index >= len && rm_index < 0) throw new IndexOutOfBoundsException();
        int data = arr[rm_index];
        int[] new_array = new int[len-1];
        for(int i=0, j=0; i < len; i++,j++) {
            if(i == rm_index) {
                j--;
            } else {
                new_array[j] = arr[i];
            }
        }
        arr = new_array;
        capacity = --len;
        return data;
    }

    // search and remove the element if it is found in array
    public boolean remove(int element) {
        for(int i=0; i < len; i++) {
            if(arr[i] == element) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    // reverse the content of the array

    /**
     * use the two pointer approach. It will have O(N) = N and space complexity = O(1).
     */
    public void reverse() {
        int left = 0;
        int right = arr.length -1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // binary search

    /**
     * Binary search on this array to find an element in O(log(n)) time
     * @return
     */
    public int binarySearch(int key) {
        int index = Arrays.binarySearch(arr,0,len,key);
        return index;
    }

    //sort
    public void sort() {
        Arrays.sort(arr,0,len);
    }






    // Iterator is still fast but not as fast as iterative for loop
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public Integer next() {
                return arr[index++];
            };
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if(len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i=0; i < len - 1; i++) {
                sb.append(arr[i]+",");
            }
            return sb.append(arr[len -1] +"]").toString();
        }

    }

    public static void main(String[] args) {
        IntArray ar = new IntArray(50);
        ar.add(3);
        ar.add(5);
        ar.add(6);
        ar.add(7);
        ar.add(9);
        ar.add(10);
        ar.add(-2);
        ar.add(0);

        System.out.println(ar);

        System.out.println("removedAt data:" + ar.removeAt(2));

        System.out.println(ar);

        System.out.println("remove data:" + ar.remove(-2));

        System.out.println(ar);

        System.out.println("remove data:" + ar.remove(32));

        System.out.println(ar);
        ar.reverse();
        System.out.println(ar);

        ar.sort();
        System.out.println(ar);

        System.out.println("binary search position: " + ((int) ar.binarySearch(10) + 1));
        System.out.println(ar);
    }
}
