package linkedlist;

/**
 * Given a Singly Linked List, the task is to find the middle of the linked list. If the number of nodes are even,
 * then there would be two middle nodes, so return the second middle node
 *
 * Input: linked list = 1 -> 2 -> 3 -> 4 -> 5
 * Output: 3
 * Explanation: There are 5 nodes in the linked list and there is one middle node whose value is 3.
 *
 * Input: linked list = 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * Output: 4
 * Explanation: There are 6 nodes in the linked list, so we have two middle nodes: 3 and 4, but we will return the second middle node which is 4.
 */
public class MiddleOfLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        //head.next.next.next.next.next = new Node(6);
        System.out.println("Middle element of the linked list is : " + findMiddle(head));
    }

    //TC is O(log N)
    //SC is O(1)
    private static int findMiddle(Node node) {
        //using slow and fast pointer approach
        Node fast = node;
        Node slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }
}
