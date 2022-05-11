package LinkedLists;

public class Node {
    int val;
    Node next;
    Node head;
    Node tail;
    public Node(int val) {
        this.val = val;
    }
    public void insert(int val) {
        Node last = new Node(val);
        Node n =  this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = last;
    }
}
