package stacks;

import java.util.Stack;

/**
 * The Next greater Element for an element x is the first greater element on the right side of x in the array.
 * Elements for which no greater element exist, consider the next greater element as -1.
 *
 * Input: arr[] = [ 4 , 5 , 2 , 25 ]
 * Output:       4      –>   5
*                5      –>   25
*                2      –>   25
*               25      –>   -1
 * Explanation: except 25 every element has an element greater than them present on the right side
 */
public class _4_NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        nextGreaterElement(arr);
        nextGreaterElementUsingStack(arr);
    }

    //TC is O(N)
    //SC is O(N)
    private static void nextGreaterElementUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            while (!stack.isEmpty() && current >= stack.peek()) {
                System.out.println(stack.pop() + " --> " + current);
            }
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> " + -1);
        }
    }

    //TC is O(N^2)
    //SC is O(1)
    private static void nextGreaterElement(int[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            int max = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    max = Math.max(arr[j], max);
                    break;
                }
            }
            System.out.println(arr[i] + " --> " + max);
        }
    }
}
