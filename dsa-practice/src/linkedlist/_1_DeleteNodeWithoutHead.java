package linkedlist;

/**
 * You are given a singly linked list and pointer which is pointing to the node which is required to be deleted. Any information about the head pointer or any other node is not given.
 * You need to write a function to delete that node from the linked list
 * Input: 1-->2-->3-->4-->null, 3
 * Output: 1-->2-->4-->null
 */
public class _1_DeleteNodeWithoutHead {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        Node node3 = new Node(3);
        head.next.next = node3;
        Node node4 = new Node(4);
        head.next.next.next = node4;
        printList(head);
        deleteNode(node3);
        System.out.println("Linked List after deletion is : ");
        printList(head);
    }

    private static void deleteNode(Node nodeToDelete) {
        //find the next node and copy that data to current node to be deleted, then make the next pointer point to that next node
        Node nextNode = nodeToDelete.next;
        if (nextNode == null) {
            System.out.println("This is last node, require head, can't be freed\n");
        } else {
            nodeToDelete.value = nextNode.value;
            nodeToDelete.next = nextNode.next;
        }
    }

    private static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("NULL\n");
    }
}
