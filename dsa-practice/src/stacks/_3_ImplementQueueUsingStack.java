package stacks;

import java.util.Stack;

/**
 * We are given a stack data structure with push and pop operations,
 * the task is to implement a queue using instances of stack data structure and operations on them
 */
public class _3_ImplementQueueUsingStack {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        enQueue(1);
        enQueue(2);
        enQueue(3);
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
    }

    //TC is O(N)
    private static int deQueue() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int element = stack2.pop();
        return element;
    }

    //TC is O(1)
    private static void enQueue(int i) {
        stack1.push(i);
    }
}
