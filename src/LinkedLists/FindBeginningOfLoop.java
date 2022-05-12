package LinkedLists;

// Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
// Definition: Circular linked list is a (corrupt) linked list in which a node's next pointer points to an
// earlier node, to make a loop in the linked list.
// eg: Input = a-> b-> c-> d-> e-> c-> (the same C as earlier)
// Output: "c"
public class FindBeginningOfLoop {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2); one.next = two;
        Node three = new Node(3); two.next = three;
        Node four = new Node(4); three.next = four;
        Node five = new Node(5); four.next = five;
        five.next = three; //creating a loop here
        Node head = one;
        Node t = head;
        //Node.printLinkedList(t);
        System.out.println("1 --> 2 --> 3 --> 4 --> 5 --> 3 --> ...");
        Node result = findBeginningOfLoop(head);
        Node.printLinkedList(result);
    }

    //Maintain a slow and fast pointer. Slow increments by 1 and fast increments by 2.
    //Run a loop till slow becomes equal to fast. Return slow/fast node as a new node
    //If loop does not exist, fast or fast.next will become null at some point. Return from here.
    // Time Complexity = O(n)
    // Space Complexity = O(n)
    private static Node findBeginningOfLoop(Node head){
        if(head == null) return null;
        Node slow = head;
        Node fast = head.next;

        while(slow != fast) {
            slow = slow.next;
            if(fast != null && fast.next!= null) fast = fast.next.next;
            else return new Node(-1);
        }
        return new Node(slow.val);
    }
}
