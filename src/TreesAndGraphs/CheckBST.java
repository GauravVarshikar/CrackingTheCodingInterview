package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

// Implement a function to check if a binary tree is a binary search tree
public class CheckBST {
    public static void main(String[] args) {
        // sorted array
        int[] input = {1,2,3,4,5,6,7,8};
        Node root = CreateBSTFromArray.generateBST(input);
        Node.display(root);
        System.out.println("Is a BST with DFS approach? : " + isBinarySearchTreeDFS(root));
        System.out.println("Is a BST with BFS approach? : " + isBinarySearchTreeBFS(root));

        // unsorted array
        input = new int[]{1,2,3,10,5,6,7,8};
        root = CreateBSTFromArray.generateBST(input);
        Node.display(root);
        System.out.println("Is a BST with DFS approach? : " + isBinarySearchTreeDFS(root));
        System.out.println("Is a BST with BFS approach? : " + isBinarySearchTreeBFS(root));
    }

    // Recursive approach using DFS
    // For each node, check if the left child has value <= parent and right child has value > parent
    // Do this recursively for both the left and the right subtrees
    public static boolean isBinarySearchTreeDFS(Node root) {
        // Base case: if leaf node then return true
        if(root == null) return true;

        // if left child exists and left child value > parent value then return false
        if(root.left != null && root.left.value > root.value) {
            return false;
        }
        // if right child exists and right child value <= parent value then return false
        if(root.right != null && root.right.value <= root.value) {
            return false;
        }
        // Check this recursively for left tree and right tree
        return isBinarySearchTreeDFS(root.left) && isBinarySearchTreeDFS(root.right);
    }

    // Iterative approach using BFS
    // Queue to maintain the nodes in the tree at each level
    public static boolean isBinarySearchTreeBFS(Node root) {
        // Base case : if root is null return true. This can be false as well.
        if(root == null) return true;
        // Queue to maintain the list of nodes in the tree
        Queue<Node> queue = new LinkedList<>();
        // Start by adding the root to the queue
        queue.add(root);

        // Iterate over the queue till its empty
        while(!queue.isEmpty()) {
            // Remove node from queue
            Node curNode = queue.poll();

            // if the current node has left child and left child's value is > current value then return false
            if(curNode.left != null && curNode.left.value > curNode.value){
                return false;
            }
            // if the current node has right child and right child's value is <= current value then return false
            if(curNode.right != null && curNode.right.value <= curNode.value) {
                return false;
            }
            // if left child exists, add it to the queue
            if(curNode.left != null) queue.add(curNode.left);
            // if right child exists, add it to the queue
            if(curNode.right != null) queue.add(curNode.right);
        }
        // if all nodes in tree are traversed that means it is a BST, return true
        return true;
     }
}
