package TreesAndGraphs;

// Given a sorted (increasing order) array, write an algorithm to create a binary search tree with minimal height.
public class CreateBSTFromArray {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        Node root = generateBST(input);
        Node.breadthFirstTraversal(root);
        Node.display(root);
    }

    public static Node generateBST(int[] input) {
        return generateBST(input, 0, input.length-1, null);
    }

    private static Node generateBST(int[] input, int start, int end, Node root) {
        // base condition: if start > end, return null
        if(start > end) return null;
        // find the mid of the sorted array
        int mid = (start+end)/2;
        // if the node is null, that means it is a parent node. create a new node with the value as array[mid]
        if(root == null){
            root = new Node(input[mid]);
        }
        // create left subtree by using numbers from 0 to mid-1
        root.left = generateBST(input, start, mid-1, root.left);
        // create right subtree by using numbers from mid+1 to last
        root.right = generateBST(input, mid+1, end, root.right);
        return root;
    }
}
