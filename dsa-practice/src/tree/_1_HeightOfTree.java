package tree;

/**
 *Given a binary tree, the task is to find the height of the tree. The height of the tree is the number of vertices in the tree from the root to the deepest node.
 *
 * input:   1
 *        2  3
 *      4  5
 * Output: 3
 */
public class _1_HeightOfTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println("Height of the tree is  : " + heightOfTree(root));
    }

    //TC is O(log N)
    //SC is O(N) as the recursive stack traversal would be O(N) when the tree is not balanced in worst case
    private static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left) , heightOfTree(root.right));
    }
}
