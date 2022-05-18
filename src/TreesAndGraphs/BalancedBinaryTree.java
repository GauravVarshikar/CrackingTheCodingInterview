package TreesAndGraphs;

// Implement a function to check if a binary tree is balanced. For the purpose of this question,
// a balanced tree is defined to be a tree such that the heights of the two subtrees of any node
// never differ by more than one.
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        Node.display(root);
        System.out.println("Height of tree: " + getHeight(root));
        System.out.println("Is Balanced? : " + isBalanced(root));
//        System.out.println("In Order Traversal");
//        Node.inOrderTraversal(root); System.out.println();
//        System.out.println("Pre Order Traversal");
//        Node.preOrderTraversal(root); System.out.println();
//        System.out.println("Post Order Traversal");
//        Node.postOrderTraversal(root); System.out.println();
//        System.out.println("Breadth First Traversal");
//        Node.breadthFirstTraversal(root); System.out.println();
    }

    // Function to return the maximum height of a tree
    // if the node is a leaf node then return 0, height of the parent of this node will be +1.
    // Similarly, we calculate the height at each node in the tree, by adding 1 to the value from its child
    // Total height of the tree will be the maximum height of the left subtree and right subtree
    private static int getHeight(Node root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // Function to check if the tree is balanced.
    // Find the height at each node using the getHeight() function.
    // At each node, check the absolute difference between the heights of left and right subtrees.
    // If the absolute difference is greater than 1, the return false. Else return true.
    private static boolean isBalanced(Node root) {
        if(root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight-rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
