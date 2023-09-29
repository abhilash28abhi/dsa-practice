package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sorted array and a number x, find a pair in an array whose sum is closest to x.
 *
 * Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
 * Output: 22 and 30
 *
 * Input: arr[] = {1, 3, 4, 7, 10}, x = 15
 * Output: 4 and 10
 */
public class _14_FindPairWithClosestSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, 10};
        int sum = 15;
        findPairOfSum(arr, sum);
    }

    //TC is O(N)
    //SC is O(1)
    private static void findPairOfSum(int[] arr, int sum) {
        int minSumDiff = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;
        int pair1 = 0;
        int pair2 = 0;

        while (start < end) {
            int currentSum = arr[start] + arr[end];

            if (Math.abs((sum - currentSum)) < minSumDiff) {
                minSumDiff = Math.abs((sum - currentSum));
                pair1 = arr[start];
                pair2 = arr[end];
            }

            if (currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println("Pairs with closest sum are : " + pair1 + ", " + pair2);
    }
}
