package linkedList;

public class Solution {
    public ListNode solve(ListNode A, int B, int C) {
        ListNode newNode = new ListNode(B);

        if(A == null) {
            return newNode;
        }

        //if pos = 0, insert at head
        if(C == 0) {
            newNode.next = A;
            A = newNode;
            return newNode;
        }

        int index = 0;
        ListNode temp = A;
        while(temp.next != null && index < C - 1) {
            index++;
            temp = temp.next;
        }

        // if temp.next = null, then append
        if(temp.next == null) {
            temp.next = newNode;
            return A;
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        SinglyLinkedList s1 = new SinglyLinkedList();
        s1.add(1);
        s1.add(2);
        s1.add(3);
//        s1.add(6);
//        s1.add(5);
//        s1.add(6);
//        s1.add(1);
//        s1.add(9);

        System.out.println("Before - ");
        s1.print();
        Solution s = new Solution();
        ListNode nn = s1.getFirst();

        ListNode na = s.solve(nn,6, 0);
        System.out.println("After - ");
        s1.print();
    }
}
