package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array arr[] of size N and a number K, where K is smaller than the size of the array.
 * Find the K’th smallest, element in the given array. Given that all array elements are distinct.
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3
 * Output: 7
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 4
 * Output: 10
 */
public class _1_KthSmallestElement {

    public static void main(String[] args) {
        int[] input = {7, 10, 4, 3, 20, 15};
        System.out.println("Kth smallest element in array is : " + kthSmallest(input, 3));
    }

    //TC is O(N) * log(k)
    //SC is O(k)
    private static int kthSmallest(int[] input, int k) {
        //creating a max heap of size k
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        for (int i = k; i < input.length; i++) {
            if (pq.peek() > input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }
        return pq.peek();
    }
}
