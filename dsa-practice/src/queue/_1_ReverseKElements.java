package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an integer k and a queue of integers, The task is to reverse the order of the first k elements of the queue,
 * leaving the other elements in the same relative order
 *
 * Input : 1-->2-->3-->4-->5, k = 3
 * Output : 3-->2-->1-->4-->5
 */
public class _1_ReverseKElements {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("K elements reversed from queue are : ");
        Queue<Integer> res = reverseKElements(queue, 3);
        while (!res.isEmpty()) {
            System.out.println(res.poll());
        }
    }

    //TC is O(N)
    //SC is O(k)
    private static Queue<Integer> reverseKElements(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0 ; i < size - k; i++) {
            queue.add(queue.poll());
        }
        return queue;
    }
}
