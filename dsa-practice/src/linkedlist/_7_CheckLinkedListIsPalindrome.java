package linkedlist;

/**
 * Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false
 * Input: 1->2->3->2->1->NULL
 * Output: true
 *
 * Input: 1->2->3->1->NULL
 * Output: false
 */
public class _7_CheckLinkedListIsPalindrome {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println("Is the input linked list a palindrome : " + isPalindrome(head));
    }

    private static boolean isPalindrome(Node head) {
        //find the middle node, then reverse from middle to end
        //compare the first and last node and move forward
        Node temp = head;
        Node mid = findMiddleNode (temp);
        Node rev = reverseList(mid);

        while (rev != null) {
            if (temp.value != rev.value) {
                return false;
            } else {
                temp = temp.next;
                rev = rev.next;
            }
        }
        return true;
    }

    private static Node reverseList(Node mid) {
        Node prev = null;
        Node next;
        Node current = mid;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static Node findMiddleNode(Node head) {
        //using 2 pointer approach
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
