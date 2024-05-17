package tree;

import java.util.Stack;

/**
 * Given a binary tree, the task is to convert the binary tree into its Mirror tree.
 * Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
 *
 *  input:    1
 *         2      3
 *       4   5
 *  Level order: 1 2 3 4 5
 *  Output:    1
 *          3      2
 *               5    4
 *       1 3 2 5 4
 */
public class _3_MirrorOfTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        mirrorOfTree(root);
    }

    //Using level order traversing but storing the content in stack in order to mirror the data
    //TC is O(N)
    //SC is O(N)
    private static void mirrorOfTree(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
