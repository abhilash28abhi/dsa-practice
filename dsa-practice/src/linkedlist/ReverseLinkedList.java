package linkedlist;

/**
 * Given a pointer to the head node of a linked list, the task is to reverse the linked list.
 * We need to reverse the list by changing the links between nodes
 *
 * Input: Head of following linked list
 * 1->2->3->4->NULL
 * Output: Linked list should be changed to,
 * 4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("Current head is : " + head.value + " Reversed linked list head is : " + reverseLinkedList(head));
    }

    //TC is O(N)
    //SC is O(1)
    private static int reverseLinkedList(Node head) {
        //use 3 pointers to save the prev, current and next node
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head.value;
    }
}
