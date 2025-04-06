package linkedList;

public class LinkedListDeepCopy {
    public RandomNode copyRandomList(RandomNode head) {

        // step 1 : Insert copied nodes next to original nodes
        RandomNode temp = head;
        while(temp != null) {
            RandomNode copyNode = new RandomNode(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        // Step 2: Assign random pointers for copied nodes
        temp = head;
        while(temp != null) {
            temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        //step 3: separate both the linked list
        RandomNode dummyHead = new RandomNode(0);
        RandomNode copyTemp = dummyHead;
        temp = head;

        while(temp != null) {
            copyTemp.next = temp.next;
            copyTemp = copyTemp.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummyHead.next;
    }

    public void printList(RandomNode head) {
        RandomNode temp = head;
        int index = 0;
        while (temp != null) {
            System.out.print("Index at:" + index  + " Value: " + temp.val);
            System.out.print(", Random: " + (temp.random != null ? temp.random.val : "null") +  " At address: " + head.hashCode());
            System.out.println();
            temp = temp.next;
            index++;
        }
    }



    public static void main(String[] args) {
        RandomNode n1 = new RandomNode(10);
        RandomNode n2 = new RandomNode(20);
        RandomNode n3 = new RandomNode(30);
        RandomNode n4 = new RandomNode(40);
        RandomNode n5 = new RandomNode(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = n4;
        n2.random = n1;
        n3.random = n3;
        n4.random = n4;
        n5.random = n3;

        System.out.println("Original List:");
        LinkedListDeepCopy res = new LinkedListDeepCopy();
        res.printList(n1);

        RandomNode copied = res.copyRandomList(n1);
        System.out.println("Deep Copy List:");
        res.printList(copied);

    }

}
