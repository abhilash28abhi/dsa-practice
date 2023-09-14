package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of N integers, and an integer K,
 * the task is to find the number of pairs of integers in the array whose sum is equal to K.
 *
 * Input: arr[] = {1, 5, 7, -1}, K = 6
 * Output:  2
 * Explanation: Pairs with sum 6 are (1, 5) and (7, -1).
 *
 * Input: arr[] = {1, 5, 7, -1, 5}, K = 6
 * Output:  3
 * Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5)
 */
public class _7_CountPairsWithSum {

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        countSumPairs(arr, sum);
    }

    // TC is O(n)
    // SC is O(n)
    private static void countSumPairs(int[] arr, int sum) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!lookup.containsKey(sum - arr[i])) {
                lookup.put(arr[i], 0);
            } else {
                count++;
            }
        }
        System.out.println("Count of pairs with given sum is : " + count);
    }
}
