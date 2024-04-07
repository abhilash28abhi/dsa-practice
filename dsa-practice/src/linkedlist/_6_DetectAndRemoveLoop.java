package linkedlist;

/**
 * Given Linked List contains a loop and if the loop is present then remove the loop and return true. If the list doesn’t contain a loop then it returns false
 * Input: 1-->2-->3-->4-->5-->2
 * Output: true
 * 1->2->3->4->5->NULL
 */
public class _6_DetectAndRemoveLoop {

    public static void main(String[] args) {
        _6_DetectAndRemoveLoop.NodeWithFlag head = new _6_DetectAndRemoveLoop.NodeWithFlag(1);
        _6_DetectAndRemoveLoop.NodeWithFlag nodeWithFlag2 = new _6_DetectAndRemoveLoop.NodeWithFlag(2);
        _6_DetectAndRemoveLoop.NodeWithFlag nodeWithFlag3 = new _6_DetectAndRemoveLoop.NodeWithFlag(3);
        _6_DetectAndRemoveLoop.NodeWithFlag nodeWithFlag4 = new _6_DetectAndRemoveLoop.NodeWithFlag(4);
        _6_DetectAndRemoveLoop.NodeWithFlag nodeWithFlag5 = new _6_DetectAndRemoveLoop.NodeWithFlag(5);
        head.next = nodeWithFlag2;
        nodeWithFlag2.next = nodeWithFlag3;
        nodeWithFlag3.next = nodeWithFlag4;
        nodeWithFlag4.next = nodeWithFlag5;
        nodeWithFlag5.next = nodeWithFlag2; //creating loop here
        detectAndRemoveLoop(head);
        System.out.println("Linked list after detecting loop is : ");
        printList(head);
    }

    private static boolean detectAndRemoveLoop(NodeWithFlag head) {
        NodeWithFlag prev = null;
        while (head != null) {
            if (head.flag == true) {
                prev.next = null;
                return true;
            } else {
                head.flag = true;
                prev = head;
                head = head.next;
            }
        }
        return false;
    }

    private static void printList (NodeWithFlag head) {
        NodeWithFlag temp = head;
        while (temp != null) {
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println("NULL\n");
    }

    static class NodeWithFlag {
        int value;
        _6_DetectAndRemoveLoop.NodeWithFlag next;
        boolean flag;

        NodeWithFlag (int value) {
            this.value = value;
            this.next = null;
            this.flag = false;
        }
    }
}
