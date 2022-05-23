package TreesAndGraphs;

// Create an algorithm to decide if T2 is a subtree of T1.
// A tree T2 is a subtree of T1 if there exists a node in T1 such that the subtree n is identical to T2.
// That is, if you cut off the tree at node n, the two tree should be identical.
public class CheckIfSubtree {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8};
        Node root = CreateBSTFromArray.generateBST(input);
        Node.display(root);

        input = new int[]{1,2,3};
        Node root2 = CreateBSTFromArray.generateBST(input);
        Node.display(root2);

        System.out.println("Is It A Subtree? " + isASubtree(root, root2));
    }

    // Function to check if a tree T2 is a subtree of T1
    // In this solution, we first go get the root of T2 from the tree T1.
    // After that start comparing each node one by one in both T1 and T2 from there.
    private static boolean isASubtree(Node root, Node root2) {
        Node node = findNode(root, root2);
        if(node == null) return false;
        return compareTree(node, root2);
    }

    // Function to find the root of T2 from the tree T1
    private static Node findNode(Node root, Node node) {
        // base case
        if(root == null) return null;
        // if we found the node, return this node
        if(root.value == node.value) return root;
        // Find node in the left tree of the root
        Node left = findNode(root.left, node);
        // Find node in the right tree of the root
        Node right = findNode(root.right, node);
        // If node not found in the tree, return null
        if(left == null && right == null) return null;
        // If left node is not null, return the left node else return right node
        return left == null? right : left;
    }

    // Function to compare two trees starting from a root node
    private static boolean compareTree(Node n1, Node n2) {
        // if nodes in both trees are null, so they are same, return true
        if(n1 == null && n2 == null) return true;
        // if any one of them is null and other is non-null, they are different, return false
        if(n1 == null) return false;
        if(n2 == null) return false;

        // if the values of both nodes are different, return false
        if(n1.value != n2.value) return false;
        // check this for all nodes in the left tree and right tree
        return compareTree(n1.left, n2.left) && compareTree(n1.right, n2.right);
    }
}