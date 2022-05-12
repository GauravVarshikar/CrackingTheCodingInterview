package LinkedLists;

// You have two numbers represented by a linked list, where each node contains a  single digit.
// The digits are stored in revers order, such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list.
// eg. i/p: 7->1->6 + 5->9->2 = 617+295
// Output: 2->1->9 == 912
public class AddLinkedListNumbers {
    public static void main(String[] args) {
        Node num1 = new Node(9); num1.insert(9); num1.insert(8);
        Node num2 = new Node(5); num2.insert(9); num2.insert(9);
        Node t1 = num1;
        Node t2 = num2;
        Node.printLinkedList(t1);
        System.out.println();
        Node.printLinkedList(t2);
        System.out.println();
        Node result = addLinkedLists(num1, num2);
        Node.printLinkedList(result);
    }

    // Time Complexity = O(n) where n is size of the longest list
    // Space Complexity = O(n)
    private static Node addLinkedLists(Node num1, Node num2) {
        if(num1 == null && num2 == null) return null;
        if(num1 == null) return num2;
        if(num2 == null) return num1;

        Node result = new Node(0);
        Node dummy = result;
        int carry = 0;

        //iterate over both lists till the end
        while(num1 != null || num2 != null) {
            //store current value if exists, if current node is null then 0
            int n1 = (num1 == null) ? 0 : num1.val;
            int n2 = (num2 == null) ? 0 : num2.val;
            //calculate sum of n1, n2 and carry
            int sum = n1 + n2 + carry;

            //create a new node having value of sum modulo 10
            Node newNode = new Node(sum % 10);
            //add new node to the result list
            dummy.next = newNode;

            //calculate new carry by sum divided by 10
            carry = sum / 10;
            dummy = dummy.next;
            num1 = num1.next;
            num2 = num2.next;
        }

        //if last 2 numbers result in carry, add the carry to the result as a new node
        if(carry != 0) {
            Node newNode = new Node(carry);
            dummy.next = newNode;
        }
        return result.next;
    }
}
