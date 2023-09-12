package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array and a number K where K is smaller than the size of the array.
 * Find the K’th smallest, element in the given array. Given that all array elements are distinct.
 * Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3
 * Output: 7
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 4
 * Output: 10
 */
public class _3_KthSmallestLargestElement {

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15}; //after sort [3 4 7 10 15 20]
        int k = 3;
        findKthSmallestElement(arr, k);
        findKthSmallestUsingPriorityQueue(arr, k);
        findKthLargestUsingPriorityQueue(arr, k); //output shd be 10
    }

    //TC O(N log N)
    private static void findKthSmallestElement(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println("Kth smallest element is : " + arr[k - 1]);
    }

    //TC is O(k) + O(n-k) * logK since heap is a complete binary tree
    // SC is O(k)
    //use a priority with max heap to get the kth smallest
    private static void findKthSmallestUsingPriorityQueue(int[] arr, int k) {
        //default PQ is min heap so using constructor to create a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //Idea is to create a PQ of K size and then find the max heap out of that
        for (int i = 0 ; i < k ; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println("Kth smallest element is : " + pq.peek());
    }

    private static void findKthLargestUsingPriorityQueue(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Idea is to create a PQ of K size and then find the min heap out of that
        for (int i = 0 ; i < k ; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length ; i++) {
            if (arr[i] >= pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        System.out.println("Kth largest element is : " + pq.peek());
    }
}
