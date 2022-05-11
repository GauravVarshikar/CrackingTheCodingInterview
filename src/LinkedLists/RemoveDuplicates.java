package LinkedLists;

import java.util.HashSet;
import java.util.Set;

// Write code to remove duplicates from an unsorted linked list
// FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.insert(2); head.insert(2);
        head.insert(3); head.insert(3);
        head.insert(4); head.insert(5);
        Node t = head;
        Node.printLinkedList(t);
        System.out.println();
        Node result = removeDuplicates(head);
        Node.printLinkedList(result);
    }



    //Maintain a HashSet of values. If a value already exists in the set then
    //set the prev node's next to current node's next, this will delete the current node
    //if duplicate == prev.next --> curr.next
    // Time Complexity = O(n)
    // Space Complexity = O(n)
    private static Node removeDuplicates(Node head){
        if(head == null) return null;
        Node cur = head;
        Set<Integer> visited = new HashSet();
        Node prev = null;

        while(cur != null) {
            if(visited.contains(cur.val)) {
                prev.next = cur.next;
            } else {
                visited.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
