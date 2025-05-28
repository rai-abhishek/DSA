//package dataStructures.trees;
//
//public class BinarySearchTree<T extends Comparable<T>> {
//    private int nodeCount = 0;
//    private Node root = null;
//
//    private class Node {
//        T data;
//        Node left, right;
//
//        public Node(T data, Node left, Node right) {
//            this.data = data;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    // isEmpty
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//
//    // size();
//    public int size() {
//        return nodeCount;
//    }
//
//    //add();
//    public boolean add(T elem) {
//        // check if the value exist, then ignore it
//        if(contains(elem)) {
//            return false;
//        }
//
//    }
//
//    // remove;
//
//    //find mix
//
//    //find max
//
//    //search
//    public boolean contains(T elem) {
//        return contains(root, elem);
//    }
//
//    public boolean contains(Node node, T elem) {
//        return false;
//    }
//
//
//
//}
