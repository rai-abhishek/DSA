package linkedList;

public class SinglyLinkedList {
    private ListNode head;
    private int size;

    public void addLast(int val) {
        if(head == null) {
            head = new ListNode(val);
            size++;
            return;
        }
        ListNode current = head;

        while(current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
        size++;
    }

    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAt(int index, int val) {
        if(index == 0) {
            addFirst(val);
        }

        ListNode newNode = new ListNode(val);
        ListNode temp = head;

        for(int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void add(int val) {
        addLast(val);
    }

    public void print() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.val  + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode getFirst() {
        return head != null ? head : null;
    }

    // search kth index
    public int contains(int k) {
        ListNode temp = head;
        int index = 0;

        while(temp != null) {
            if(temp.val == k) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public void deleteAt(int index) {
        if(index < 0 || index > size) return;

        if(index == 0) {
            head = head.next;
        } else {
            ListNode temp = head;
            for(int i = 0; i < index -1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }

    public void deleteValue(int x) {
        if(head == null) return;
        if(head.val == x) {
            head = head.next;
            size--;
            return;
        }
        ListNode temp = head;
        while (temp.next != null && temp.next.val != x) {
            temp = temp.next;
        }
        if(temp.next != null) {
            temp.next = temp.next.next;
            size--;
        }
    }

    public int getSize() {
        return size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void reverse() {
        ListNode prev = null,curr = head;
        while(curr != null) {
            ListNode currKaNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currKaNext;
        }
        head = prev;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(15);
        list.add(35);
        list.add(21);

        list.print();

        System.out.println(list.contains(15));
        System.out.println(list.contains(60));

        list.addFirst(5);
        list.addAt(3,100);
        list.addAt(3,110);

        list.print();
        System.out.println(list.size);
        list.deleteAt(2);
        list.deleteValue(35);
        list.print();
        list.reverse();
        list.print();
    }
}
