package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

// Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
// Avoid storing additional nodes in a data structure.
// NOTE: This is not necessarily a binary search tree

public class FirstCommonAncestor {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,10,6,7,8};
        Node root = CreateBSTFromArray.generateBST(input);
        Node.display(root);
        Integer ancestor = findFirstCommonAncestor(root, 10, 8);
        System.out.println("First Common Ancestor of 10 and 8 using additional data structure : " + ancestor);

        Node commAncs = findAncestor(root, 8, 6);
        System.out.println("First Common Ancestor of 6 and 8 without additional data structure: " + commAncs.value);
    }

    // Approach 1: Find the paths of both nodes and store them in separate List
    // Iterate through the list till the element differ or th list ends
    // Time Complexity: O(n)
    // Space Complexity: O(n) to store the paths
    private static Integer findFirstCommonAncestor(Node root, int node1, int node2) {
        // base case for an empty tree
        if(root == null) return null;

        // List to store path of node 1
        List<Integer> path1 = new ArrayList<>();
        // Call the function to get the path node 1
        hasPath(root, path1, node1);
        System.out.println("Path of " + node1 + " : " + path1);
        // List to store path of node 2
        List<Integer> path2 = new ArrayList<>();
        // Call the function to get the path of node 2
        hasPath(root, path2, node2);
        System.out.println("Path of " + node2 + " : " + path2);

        // Find the smallest list, use that as the length for iterating
        int len = Math.min(path1.size(), path2.size());
        // default ancestor
        int ancestor = -1;

        // iterate over the path lists
        for(int i = 0; i<len; i++){
            // break the loop when the values in the two lists differ at the same location
            if(path1.get(i) != path2.get(i)) {
                break;
            }
            // keep updating the ancestor till the values match
            ancestor = path1.get(i);
        }

        // return the ancestor
        return ancestor;
    }

    // Returns true if there is a path from root to the given node.
    // It also populates 'arr' with the given path
    public static boolean hasPath(Node root, List<Integer> arr, int x)
    {
        // if root is NULL there is no path
        if (root==null) return false;

        // push the node's value in 'arr'
        arr.add(root.value);

        // if it is the required node return true
        if (root.value == x) return true;

        // else check whether the required node lies in the left subtree or right subtree of the current node
        if (hasPath(root.left, arr, x) || hasPath(root.right, arr, x)) return true;

        // required node does not lie either in the left or right subtree of the current node
        // Thus, remove current node's value from 'arr'and then return false
        arr.remove(arr.size()-1);
        return false;
    }

    // Approach 2: Actual solution, iterate over the tree, if any of the node found then return that as the root
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static Node findAncestor(Node root, int n1, int n2) {
        // base case
        if(root == null) return null;

        // if n1 or n2 found in the tree, return the node
        if(root.value == n1 || root.value == n2) return root;

        // Find nodes in the left subtree
        Node leftNode = findAncestor(root.left, n1, n2);
        // Find nodes in the right subtree
        Node rightNode = findAncestor(root.right, n1, n2);

        // if both leftnode and rightnode are not null, that means one node is in left and other node is in right trees
        // in that case, return the current node as the ancestor
        if(leftNode != null && rightNode != null) return root;

        // if both nodes are in left or right tree, either left or right nodes will be null
        // return the node that is not null as the ancestor
        return leftNode != null? leftNode : rightNode;
    }

}