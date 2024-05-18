package tree;

/**
 * A Binary Search Tree (BST) is a node-based binary tree data structure that has the following properties.
 *
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * Each node (item in the tree) has a distinct key.
 *
 * Input:      4
 *         2       5
 *      1    3
 *  Output : yes
 */
public class _5_CheckIfBST {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println("The given tree is BST : " + checkIfBST(root));
    }

    //TC is O(N)
    //SC is O(log N)
    private static boolean checkIfBST(Node root) {
        int left = 0;
        int right = 0;
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else {
            if (root.left != null) {
                left = root.left.value;
            }
            if (root.right != null) {
                right = root.right.value;
            }

            if ((left < root.value && right > root.value) && checkIfBST(root.left) && checkIfBST(root.right)) {
                return true;
            }
        }
        return false;
    }
}
