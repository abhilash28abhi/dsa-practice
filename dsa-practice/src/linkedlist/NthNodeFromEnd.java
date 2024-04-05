package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a Linked List and a number N, write a function that returns the value at the Nth node from the end of the Linked List
 *
 * Input: 1 -> 2 -> 3 -> 4, N = 3
 * Output: 2
 *
 * Input: 35 -> 15 -> 4 -> 20, N = 4
 * Output: 35
 */
public class NthNodeFromEnd {

    public static void main(String[] args) {
        Node head = new Node(35);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);
        System.out.println("Nth Node from the end is : " + nthNodeFromEnd(head, 3));
        System.out.println("Nth Node from the end is : " + nthNodeFromEndWithoutExtraSpace(head, 4));
    }

    //TC is O(N)
    //SC is O(N)
    private static int nthNodeFromEnd(Node head, int N) {
        //iterate over the linked list and store the index and value in map, then retrieve the value at size - N position
        Map<Integer, Integer> lookup = new HashMap<>();
        Node current = head;
        int position = 0;
        while (current != null) {
            lookup.put(position, current.value);
            current = current.next;
            position++;
        }
        return lookup.get(position - N);
    }

    private static int nthNodeFromEndWithoutExtraSpace(Node head, int N) {
        //iterate over the linked list and store the index and value in map, then retrieve the value at size - N position
        Node current = head;
        int position = 0;
        while (current != null) {
            current = current.next;
            position++;
        }
        current = head;
        //starting with index 1 as we don't need the next node for 0th node
        for (int i = 1; i < position - N + 1; i++) {
            current = current.next;
        }
        return current.value;
    }
}
