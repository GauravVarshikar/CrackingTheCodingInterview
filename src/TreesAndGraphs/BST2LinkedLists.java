package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
// e.g. if you have a tree with depth D, you'll have D linked lists
public class BST2LinkedLists {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8};
        Node root = CreateBSTFromArray.generateBST(input);
        Node.display(root);

        int level = 0;
        List<LinkedList<Node>> listOfNodesWithDepth = getListOfNodeAtDepth(root);
        for(LinkedList<Node> nodes: listOfNodesWithDepth) {
            System.out.println(level++ + " : " + nodes);
        }
    }

    // Doing a Depth First Traversal on the tree using a Queue
    private static List<LinkedList<Node>> getListOfNodeAtDepth(Node root) {
        // base case, if root is null
        if(root == null) return null;

        Queue<DepthLevelNode> queue = new LinkedList<>();
        List<LinkedList<Node>> result = new ArrayList<>();
        //Create a new object for the root node
        DepthLevelNode top = new DepthLevelNode(0, root);
        //Add the new object to the queue. This queue will be iterated
        queue.add(top);
        //Create a linked list object for the root node
        LinkedList<Node> nodeLinkedList = new LinkedList<>();
        //counter for level
        int prevLevel = 0;

        // iterate through the queue
        while(!queue.isEmpty()) {
            // get the first object from the queue
            DepthLevelNode levelNode = queue.poll();
            // extract the tree node from the queue object
            Node treeNode = levelNode.node;
            // if the depth of object is same as the previous level
            if(levelNode.depth == prevLevel) {
                // keep adding the object to the linked list
                nodeLinkedList.add(levelNode.node);
            }
            // when level changes, new level encountered different from previous level
            else {
                // first add the linked list so far to the result List
                result.add(nodeLinkedList);
                // Create a new linked list object for this depth level
                nodeLinkedList = new LinkedList<>();
                // add the current tree node to the linked list
                nodeLinkedList.add(treeNode);
                // update the previous level counter to the new level
                prevLevel = levelNode.depth;
            }

            // if the left tree of the current tree node is not empty
            if(treeNode.left != null) {
                //create a new object with depth and tree node and add it to the queue
                queue.add(new DepthLevelNode(prevLevel+1, treeNode.left));
            }
            if(treeNode.right != null) {
                //create a new object with depth and tree node and add it to the queue
                queue.add(new DepthLevelNode(prevLevel+1, treeNode.right));
            }
        }
        //finally, add the last level of linked list formed in the last iteration to the result
        result.add(nodeLinkedList);

        return result;
    }
}

class DepthLevelNode {
    int depth;
    Node node;
    public DepthLevelNode(int depth, Node node) {
        this.depth = depth;
        this.node = node;
    }
}
