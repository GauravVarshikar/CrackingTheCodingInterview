package LinkedLists;

// Implement a function to check if a linked list is a palindrome
// eg. amatama is a palindrome
// eg. 1234321 is a palindrome
public class CheckPalindrome {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.insert(2); head.insert(9);
        head.insert(3); head.insert(3); head.insert(9);
        head.insert(2); head.insert(1);
        Node t = head;
        Node.printLinkedList(t);System.out.println();
        System.out.println("Is a Palindrome? " + isPalindrome(head));
    }

    // Since we don't have handle to the tail of the list, we iterate through the list once and create its reverse list
    // Then we iterate both the original and reverse list together and compare each element value
    // If any values dont match, list is not a palindrome so return false
    // If the iteration completes fully, all values are matching so list is a palindrome, return true
    // Time Complexity = O(n)
    // Space Complexity = O(n)
    private static boolean isPalindrome(Node head) {
        if(head == null) return true;
        Node dummy = head;
        Node reverse = null;

        while(dummy != null) {
            Node newNode = new Node(dummy.val);
            newNode.next = reverse;
            reverse = newNode;
            dummy = dummy.next;
        }
        while(head != null) {
            if(head.val != reverse.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}
