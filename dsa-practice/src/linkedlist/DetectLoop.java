package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, check if the linked list has a loop (cycle) or not.
 * Input: 1-->2-->3-->4-->5-->2
 * Output: true
 *
 * Input: 1-->2-->3-->4-->5-->null
 * output: false
 */
public class DetectLoop {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node2;
        System.out.println("Linked list has a loop : " + detectLoop(head));

        NodeWithFlag head1 = new NodeWithFlag(1);
        NodeWithFlag nodeWithFlag2 = new NodeWithFlag(2);
        NodeWithFlag nodeWithFlag3 = new NodeWithFlag(3);
        NodeWithFlag nodeWithFlag4 = new NodeWithFlag(4);
        NodeWithFlag nodeWithFlag5 = new NodeWithFlag(5);
        head1.next = nodeWithFlag2;
        nodeWithFlag2.next = nodeWithFlag3;
        nodeWithFlag3.next = nodeWithFlag4;
        nodeWithFlag4.next = nodeWithFlag5;
        nodeWithFlag5.next = nodeWithFlag2;
        System.out.println("Linked list has a loop : " + detectLoopWithoutUsingSpace(head1));
    }

    //TC is O(N)
    //SC is O(N)
    private static boolean detectLoop(Node head) {
        Set<Integer> values = new HashSet<>();
        while (head != null) {
            if (values.contains(head.value)) {
                return true;
            }
            values.add(head.value);
            head = head.next;
        }
        return false;
    }

    //TC is O(N)
    //SC is O(1)
    private static boolean detectLoopWithoutUsingSpace(NodeWithFlag head) {
        //idea is if we visit any node then jst update the flag to true and if it appears again then there is a loop
        while (head != null) {
            if (head.flag == false) {
                head.flag = true;
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    static class NodeWithFlag {
        int value;
        NodeWithFlag next;
        boolean flag;

        NodeWithFlag (int value) {
            this.value = value;
            this.next = null;
            this.flag = false;
        }
    }
}
