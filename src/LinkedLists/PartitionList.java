package LinkedLists;

//Write code to partition a linked list around a value x, such that all nodes less than x
// come before all nodes greater than or equal to x.
public class PartitionList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.insert(2); head.insert(9);
        head.insert(3); head.insert(7);
        head.insert(4); head.insert(5);
        Node t = head;
        Node.printLinkedList(t);
        System.out.println();
        Node result = partitionList(head, 4);
        Node.printLinkedList(result);
    }

    //Create 2 linked lists LEFT and RIGHT, Left will store all values < x, Right will store all values >= x
    //Merge the 2 lists by pointing left's tail node to right's head node
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    private static Node partitionList(Node head, int x) {
        Node leftHead = null; //HEAD For all nums less than x
        Node leftTail = null; //TAIL FOR ABOVE
        Node rightHead = null; //For all nums greater than or equal to x
        Node rightTail = null; //TAIL FOR ABOVE

        while(head != null) {
            Node curNode = new Node(head.val);
            if(head.val < x){
                if(leftHead == null) {
                    leftHead = curNode;
                    leftTail = leftHead;
                }
                else {
                    leftTail.next = curNode;
                    leftTail = curNode;
                }
            } else {
                if(rightHead == null) {
                    rightHead = curNode;
                    rightTail = rightHead;
                }
                else {
                    rightTail.next = curNode;
                    rightTail = curNode;
                }
            }
            head = head.next;
        }
        //if the left list remains null simply return the right list
        if(leftHead == null) {
            return rightHead;
        }
        //merge both left and right list by pointing left tail's next to right's head
        leftTail.next = rightHead;
        return leftHead;
    }
}