package LinkedLists;

//Implement an algorithm to find the kth to last element of a singly linked list
public class KthLastElement {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.insert(2); head.insert(9);
        head.insert(3); head.insert(7);
        head.insert(4); head.insert(5);
        Node t = head;
        Node.printLinkedList(t);
        System.out.println();
        int k = 3;
        System.out.println("Find kth to last element, K is: " + k);
        System.out.println("Answer: " + findKthLastElement(head, k));

        k = 9;
        System.out.println("Find kth to last element, K is: " + k);
        System.out.println("Answer: " + findKthLastElement(head, k));
    }

    //Classic case of maintaining 2 pointers = slow and fast
    //Increment fast pointer till it reaches k
    //then increment slow pointer separately till the fast pointer reaches the end of list
    //now the slow pointer is pointing to the Kth element from last
    //Time Complexity = O(n)
    //Space Complexity = O(i)
    private static int findKthLastElement(Node head, int k) {
        Node runner = head;
        for(int i = 0; i < k; i++){
            if(runner.next == null) return -1; //Handle case if k is larger than list size
            runner = runner.next;
        }
        while(runner!= null) {
            head = head.next;
            runner = runner.next;
        }
        return head.val;
    }
}
