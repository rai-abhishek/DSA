package dataStructures.queue;

import java.util.Arrays;

/**
 * Besides the Generics, the loss of property of size is another difference between ArrayQueue and
 * IntQueue. The size of ArrayQueue is calculated by the formula, as are empty status and full
 * status.
 *
 * <p>ArrayQueue maximum size is data.length - 1. The place of the variable rear is always in front
 * of the variable front logistically if regard the data array as circular. so the number of states
 * of the combination of rear and front is the length of the data array. And one of the total states
 * is used to be the judge if the queue is empty or full.
 *
 * Summary
 * ### **Quick Notes: Circular Queue Implementation**
 *
 * #### **Key Variables**
 * - **`front`**: Points to the index of the first element in the queue (the next element to be dequeued).
 * - **`rear`**: Points to the index where the next element will be inserted.
 * - **Capacity**: The queue uses an array of size `capacity + 1` to distinguish between a full and empty state.
 *
 * ---
 *
 * ### **Methods Explained**
 *
 * #### 1. **`offer(T elem)`**
 *    - **Purpose**: Adds an element to the queue.
 *    - **Process**:
 *      1. Check if the queue is full using `isFull()`. Throw an exception if true.
 *      2. Insert the element at the current `rear` index.
 *      3. Increment `rear` (with wrapping using `adjustIndex()`).
 *    - **Impact**:
 *      - `rear` moves forward to the next slot after insertion.
 *      - Wrapping occurs when `rear` reaches the end of the array.
 *
 * ---
 *
 * #### 2. **`poll()`**
 *    - **Purpose**: Removes and returns the element at the front of the queue.
 *    - **Process**:
 *      1. Check if the queue is empty using `isEmpty()`. Throw an exception if true.
 *      2. Retrieve the element at the `front` index.
 *      3. Increment `front` (with wrapping using `adjustIndex()`).
 *    - **Impact**:
 *      - `front` moves forward to point to the next element in the queue.
 *      - Wrapping occurs when `front` reaches the end of the array.
 *
 * ---
 *
 * #### 3. **`peek()`**
 *    - **Purpose**: Returns the element at the front of the queue without removing it.
 *    - **Process**:
 *      1. Check if the queue is empty using `isEmpty()`.
 *      2. Return the element at the `front` index.
 *    - **Impact**:
 *      - Neither `front` nor `rear` changes.
 *
 * ---
 *
 * #### 4. **`isFull()`**
 *    - **Purpose**: Checks if the queue is full.
 *    - **Logic**:
 *      - A queue is full when the next position of `rear` (after increment) equals `front`.
 *    - **Formula**:
 *      ```java
 *      return (front + data.length - rear) % data.length == 1;
 *      ```
 *
 * ---
 *
 * #### 5. **`isEmpty()`**
 *    - **Purpose**: Checks if the queue is empty.
 *    - **Logic**:
 *      - A queue is empty when `front == rear`.
 *
 * ---
 *
 * #### 6. **`size()`**
 *    - **Purpose**: Returns the number of elements in the queue.
 *    - **Formula**:
 *      ```java
 *      return (rear + data.length - front) % data.length;
 *      ```
 *
 * ---
 *
 * ### **Why Capacity is `+1`?**
 * 1. **Avoids Ambiguity**:
 *    - Without the extra slot, the full and empty states of the queue would both satisfy `front == rear`, causing ambiguity.
 * 2. **Buffer Space**:
 *    - The extra slot ensures that there is always a clear distinction:
 *      - **Full Queue**: `isFull()` triggers when one slot is left.
 *      - **Empty Queue**: `isEmpty()` triggers when `front == rear`.
 *
 * ---
 *
 * ### **Wrapping with `adjustIndex()`**
 * - Ensures indices (`front` and `rear`) wrap around when they exceed the array bounds.
 * - Formula:
 *   ```java
 *   return index >= size ? index - size : index;
 *   ```
 *
 */


public class ArrayQueue<T> implements Queue<T>{
    private Object[] data;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        data = new Object[capacity + 1];
        front = 0;
        rear = 0;
    }

    @Override
    public void offer(T element) {
        if(isFull()) {
            throw new RuntimeException("Queue is full");
        }
        data[rear++]  = element;
        rear = adjustIndex(rear, data.length);
    }

    @Override
    public T poll() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        front = adjustIndex(front, data.length);
        return (T)data[front++];
    }

    @Override
    public T peak() {
        System.out.println("peak: " + "front: " + front + " rear: " + rear);
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return (T) data[front];
    }

    @Override
    public int size() {
        return adjustIndex(rear + data.length,data.length);
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (front + data.length - rear) % data.length ==1;
    }

    private int adjustIndex(int index, int size) {
        return index >= size ? index - size : index;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> qq = new ArrayQueue<>(5);

        qq.offer(10);
        System.out.println(qq);

        qq.offer(5);
        System.out.println(qq);

        qq.offer(16);
        System.out.println(qq);

        qq.offer(-2);
        System.out.println(qq);

        qq.offer(3);
        System.out.println(qq);

        System.out.println(qq.poll());
        System.out.println(qq.poll());
        System.out.println(qq.poll());
    }
}
