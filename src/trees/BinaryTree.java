package trees;

import numbers.Solution;

import java.util.*;




// Binary Search Tree class
public class BinaryTree {
    Node root;

    // Insert method for BST
    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    void printTree() {
        StringBuilder sb = new StringBuilder();
        printPreOrder(sb, "", "",root);
        System.out.println(sb.toString());
    }

    void printPreOrder(StringBuilder sb, String padding, String pointer,Node node) {
        if(node == null) return;
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.data);
        sb.append("\n");
        StringBuilder paddingBuilder = new StringBuilder(padding);
        paddingBuilder.append("│  ");

        String paddingForBoth = paddingBuilder.toString();
        String pointerForRight = "└──";
        String pointerForLeft = (node.right != null) ? "├──" : "└──";

        printPreOrder(sb, paddingForBoth, pointerForLeft, node.left);
        printPreOrder(sb, paddingForBoth, pointerForLeft, node.right);
    }

    void preOrderTraversal(Node node) {
        if(node == null) return;
        System.out.print(node.data + " -- ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderTraversal(Node node) {
        if(node == null) return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " -- ");
        inOrderTraversal(node.right);
    }

    void postOrderTravsersal(Node node) {
        if(node == null) return;

        postOrderTravsersal(node.right);
        postOrderTravsersal(node.left);
        System.out.print(node.data + " -- ");
    }

    void IterativeInOrderTraversal(Node node) {
        Node curr = node;
        Stack<Node> st = new Stack<>();
        while(curr != null && st.size() > 0) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                System.out.println(curr.data);
                curr = curr.right;
            }
        }
    }

    void levelOrderTraversal(Node node) {
        Node curr = node;
        Deque<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                Node rn = q.pop();
                System.out.print(rn.data + " ");
                if(rn.left != null) {
                    q.add(rn.left);
                }
                if(rn.right != null) {
                    q.add(rn.right);
                }
            }
            System.out.println("\n");
        }
    }

    void printLeftViewOfBinaryTree(Node node) {
        Node curr = node;
        Deque<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                Node rn = q.pop();
                if(i == 0) {
                    System.out.print(rn.data + " ");
                }

                if(rn.left != null) {
                    q.add(rn.left);
                }
                if(rn.right != null) {
                    q.add(rn.right);
                }
            }
        }
    }

    public ArrayList<Integer> solve(Node A) {
        Node curr = A;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(A);
        while(q.size() > 0) {
            int sz = q.size();

            for(int i = 0; i < sz; i++) {
                Node rm = q.poll();
                ans.add(rm.data);
                if(rm.left != null) {
                    q.add(rm.left);
                } else {
                    ans.add(-1);
                }
                if(rm.right != null) {
                    q.add(rm.right);
                } else {
                    ans.add(-1);
                }
            }
        }
        return ans;
    }

    public boolean bstSearch(Node root, int k) {
        if(root == null) return false;
        if(root.data == k) return true;
        else if(k < root.data) {
            return bstSearch(root.left,k);
        } else {
           return  bstSearch(root.right,k);
        }
    }

    public boolean bstSearchIterative(Node root, int k) {
        Node curr = root;

        while(curr != null) {
            if(curr.data == k) return true;
            else if(k < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return false;
    }

    public Node insertNew(Node root, int k) {
        if(root == null) {
            Node nn = new Node(k);
            return nn;
        }

        if(root.data == k) {
            return root;
        } else if(k < root.data) {
            insert(root.left,k);
        } else {
            insert(root.right,k);
        }
        return root;
    }

    public int findSmallestElemInBST(Node root) {
        Node curr = root;
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    public int findLargestElemInBST(Node root) {
        Node curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }



    // Main method to test
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes
        tree.root = tree.insert(tree.root, 1);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 5);

        boolean z = tree.bstSearch(tree.root,6);
        System.out.println(z);

        boolean za = tree.bstSearchIterative(tree.root,5);
        System.out.println(za);

        int a = tree.findSmallestElemInBST(tree.root);
        System.out.println(a);
        System.out.println(tree.findLargestElemInBST(tree.root));

//        ArrayList<Integer> a = new ArrayList<>();
//        a = tree.solve(tree.root);
//        for(Integer i : a) {
//            System.out.print(i + " ");
//        }


//        // Print tree using iterative traversal
//        System.out.println("Tree");
//        tree.printTree();
//        System.out.println("Pre order Traversal");
//        tree.preOrderTraversal(tree.root);
//        System.out.println();
//
//        System.out.println("In order Traversal");
//        tree.inOrderTraversal(tree.root);
//        System.out.println();
//
//        System.out.println("Post order Traversal");
//        tree.postOrderTravsersal(tree.root);
//        System.out.println();
//
//        System.out.println("Iterative In order Traversal");
//        tree.postOrderTravsersal(tree.root);
//        System.out.println();
//
//        System.out.println("Level order Traversal");
//        tree.levelOrderTraversal(tree.root);
//        System.out.println();
//
//        System.out.println("Left view of tree");
//        tree.printLeftViewOfBinaryTree(tree.root);
//        System.out.println();
//        Queue<Node> q = new LinkedList<>();

    }
}
