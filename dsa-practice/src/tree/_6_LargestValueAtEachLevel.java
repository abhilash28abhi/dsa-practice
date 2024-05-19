package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find the largest value in each level.
 *
 * Input :  1
 *        2   3
 * Output: 1 3
 *
 * Input:      4
 *         9       2
 *      3    5        7
 * Output : 4 9 7
 */
public class _6_LargestValueAtEachLevel {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(9);
        root.right = new Node(2);
        root.right.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        largestAtLevel(root);
    }

    //using level order traversal and printing the max value at that level
    //TC is O(N)
    //SC is O(N) because the maximum number of nodes that can be present in the last level of a binary tree is (N+1)/2, where N is the total number of nodes in the tree. Therefore, the space complexity of the algorithm is O((N+1)/2), which simplifies to O(N) in the worst case.
    private static void largestAtLevel(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int maxValue = Integer.MIN_VALUE;
            int n = queue.size();
            for (int i = 0 ; i < n ; i++) {
                Node node = queue.poll();
                maxValue = Math.max(maxValue, node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println(maxValue);
        }
    }
}
