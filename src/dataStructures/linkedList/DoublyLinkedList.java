package dataStructures.linkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    //Internal Node class to represent data
    private static class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    //Empty this linked list O(n)
    public void clear() {
        Node<T> trav = head;

        while(trav != null) {
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = trav = null;
        size = 0;
    }

    //return the size of the linked list
    public int size() {
        return size;
    }

    //Is the linked list empty
    public boolean isEmpty() {
        return size() == 0;
    }

    //Add an element to the tail of the linked list, O(1)
    public void add(T elem) {
        addLast(elem);
    }

    //Add a node to the tail of the linked list O(1)

    /**
     * if a node is getting added at the end, then the tail.next will be used and new Node will be created
     * Similarly if a node is getting added at the start, then the head.prev will be used and new Node will be created
     *
     */
    public void addLast(T elem) {
        if(isEmpty()) {
            head = tail = new Node<T>(elem,null,null);
        } else {
            tail.next = new Node<T>(elem,tail,null); //this means tail.next = prev
            tail = tail.next;
        }
        size++;
    }

    // Add an element to the beginning of this linked list, O(1)
    public void addFirst(T elem) {
        if(isEmpty()) {
            head = tail = new Node<T>(elem,null,null);
        } else {
            head.prev = new Node(elem,null,head);
            head = head.prev;
        }
    }

    // Add an element at a specified index
    public void addAt(int index, T data) throws Exception {
        if(index < 0 || index > size) {
            throw new Exception("Illegal Index");
        }

        // insert at start if index = 0
        if (index == 0) {
            addFirst(data);
            return;
        }
        //insert at end if index = size
        if(index == size) {
            addLast(data);
            return;
        }

        //initialize the temp node with Head and traverse till it reach index value
        Node<T> current = head;

        for(int i =0; i < index - 1;i++){
            current = current.next;
        }

        /**
         * Create new node
         * Before the Insertion:
         * current is the node before the index where the new node will be inserted.
         * current.next is the node at the index where the new node will be inserted.
         * newNode is the new node being added.
         */
        Node<T> newNode = new Node(data,current,current.next); //insert the new node between current and current.next
        current.next.prev = newNode; // point the prev of current.next (forward) to newNode
        current.next = newNode; // point the current.next to new node
        size++;
    }

    // Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("Empty List");
        return head.data;
    }

    // Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty List");
        return tail.data;
    }

    // Remove the first value at the head of the linked list, O(1)
    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("Empty List");

        //Extract the data at the head and move
        T data = head.data;
        head = head.next; //move to the next Node
        size--;
        head.prev = null;
        return data;
    }

    // Remove the last value at the tail of the linked list, O(1)
    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("Empty List");

        //Extract the data at the head and move
        T data = tail.data;
        tail = tail.prev; //move to the next Node
        tail.next = null;
        --size;
        return data;
    }

    // Remove an arbitrary node from the linked list, O(1)
    private T remove(Node<T> node) {
        // if head or tail, remove it
        if(node.prev == null) return removeFirst();
        if(node.next == null) return removeLast();

        //skip the node
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // store the data to pass later
        T data = node.data;

        //momory cleanup
        node.data = null;
        node = node.prev = node.next = null;
        --size;
        return data;
    }

    // Remove a node at a particular index, O(n)
    public T removeAt(int index) {
        // validate index
        if(index < 0 || index > size) throw new IllegalArgumentException();

        //declare I here as inside the loop, we are using I & trav. Both has different data type, so it need to declared before
        int i;
        //Declare traversing node
        Node<T> trav;

        /**
         * Search from front or back of list
         * size /2 is the middle node
         * if the index is < size/2 then it is closed to head otherwise tail
         */
        if(index < size/2 ) {
            for(i = 0,trav = head;i != index;i++) {
                trav = trav.next;
            }
        } else {
            for(i = size -1,trav = tail;i != index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    // Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj) {
        Node<T> trav = head;

        //Support searching for null for cases where the data is null
        if(obj == null) {
            for(trav = head;trav !=null;trav = trav.next) {
                if(trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for(trav = head; trav != null; trav = trav.next) {
                if(obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {
        int index = 0;
        Node<T> trav = head;

        //Support searching for null for cases where the data is null
        if(obj == null) {
            for(; trav != null; trav = trav.next,index++) {
                if(trav.data == null) {
                    return index;
                }
            }
        } else {
            for(;trav != null; trav = trav.next,index++) {
                if(obj.equals(trav.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    // Check is a value is contained within the linked list
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
//            sb.append("{Prev:" + trav.prev + " Data:"+ trav.data + " Next:" + trav.next + "} ");
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(" --> ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(3);
        list.addLast(2);
        list.addLast(5);
        list.add(10);
        list.add(7);
        list.addFirst(12);
        System.out.println(list);
        System.out.println("adding new Node: Index: 2, Data: 42");
        list.addAt(2,42);
        System.out.println(list);
        System.out.println("Removing First Node");
        list.removeFirst();
        System.out.println(list);
        System.out.println("Removing Last Node");
        list.removeLast();
        System.out.println(list);
        System.out.println("Removing node at index: 2");
        System.out.println(list.removeAt(2));;
        System.out.println(list);
        System.out.println("removing value:42 " +  list.remove(42));
        System.out.println(list);
        System.out.println("Index of 2 in LL is " + list.indexOf(2));

        DoublyLinkedList<String> ss = new DoublyLinkedList<>();
        ss.add("a");
        ss.add("b");
        ss.add("Z");
        ss.add("S");
        ss.add("F");
        ss.add("R");
        ss.add("u");
        System.out.println(ss);
        ss.remove("F");
        System.out.println(ss);
        System.out.println("Index of R in LL is " + ss.indexOf("R"));
        System.out.println("Is 'Z' present in LL: " + ss.contains("Z"));
    }

}
