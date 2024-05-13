package tree;

/**
 * Write a function to determine if two trees are identical or not:
 * Two trees are identical when they have the same data and the arrangement of data is also the same
 *
 * Input:             1                    1
 *                  /   \                /   \
 *                2      3             2      3
 *              /                    /
 *            4                    4
 * Output: Both trees are identical
 *
 * Input:             1                    1
 *                  /   \                /   \
 *                2      3             5      3
 *                      /             /
 *                     4             4
 * Output: Trees are not identical
 */
public class _2_IdenticalTree {

    public static void main(String[] args) {
        Node tree1 = new Node(1);
        tree1.left = new Node(2);
        tree1.right = new Node(3);
        tree1.left.left = new Node(4);

        Node tree2 = new Node(1);
        tree2.left = new Node(2);
        tree2.right = new Node(3);
        tree2.left.left = new Node(4);
        System.out.println("The 2 trees are identical ? : " + areTreesIdentical(tree1, tree2));
    }

    //TC is O(M + N)
    //SC is O(M + N)
    private static boolean areTreesIdentical(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null)
            return true;

        if (null != tree1 && null != tree2) {
            return tree1.value == tree2.value && areTreesIdentical(tree1.left, tree2.left)
                    && areTreesIdentical(tree1.right, tree2.right);
        }
        return false;
    }
}
