package tree;

/**
 * Given a binary tree, the task is to check for every node, its value is equal to the sum of values of its immediate left and right child.
 * For NULL values, consider the value to be 0.
 *
 *           10
 *       8        2
 *    3    5    2
 */
public class _4_ChildrenSumProperty {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        System.out.println("The binary tree has children sum property as : " + childrenSum(root));
    }

    //TC is O(N)
    //SC is O(log N) because the maximum number of frames on the stack at any time is determined by the maximum depth of the recursion, which is equal to the height of the tree.
    private static boolean childrenSum(Node root) {
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

            if (root.value == (left + right) && childrenSum(root.left) && childrenSum(root.right)) {
                return true;
            }
        }
        return false;
    }
}
