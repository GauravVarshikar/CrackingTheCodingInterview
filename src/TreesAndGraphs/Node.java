package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

// Default binary tree to be used in all the problems in this section
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    // In-order Traversal
    public static void inOrderTraversal(Node root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.value + " -> ");
        inOrderTraversal(root.right);
    }

    // Pre-Order Traversal
    public static void preOrderTraversal(Node root) {
        if(root == null) return;
        System.out.print(root.value + " -> ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // Post-Order Traversal
    public static void postOrderTraversal(Node root) {
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " -> ");
    }

    // Breadth First Traversal
    public static void breadthFirstTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " -> ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }

    // Ignore these functions - display() and displayR(). These are only used to display the tree
    // Not written by me. Copied from somewhere.
    public static void display(Node root) {
        final int height = 3, width = 20;
        int len = width * height * 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 1; i <= len; i++)
            sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');

        displayR(sb, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sb);
    }
    private static void displayR(StringBuilder sb, int c, int r, int d, int w, Node n,
                          String edge) {
        if (n != null) {
            displayR(sb, c - d, r + 2, d / 2, w, n.left, " /");

            String s = String.valueOf(n.value);
            int idx1 = r * w + c - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sb.length())
                sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);

            displayR(sb, c + d, r + 2, d / 2, w, n.right, "\\ ");
        }
    }
}
