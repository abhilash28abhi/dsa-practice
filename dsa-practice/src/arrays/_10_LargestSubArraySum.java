package arrays;

/**
 * Given an array arr[] of size N.
 * The task is to find the sum of the contiguous subarray within a arr[] with the largest sum.
 *
 * Input: { -2, -3, 4, -1, -2, 1, 5, -3 }
 * Output: Max sum is 7
 */
public class _10_LargestSubArraySum {

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        largestSubArrSum(arr);
    }

    //Using Kadane's algo to solve it in O(N)
    private static void largestSubArrSum(int[] arr) {
        int currentSum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];

            if (currentSum >= maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        System.out.println("Max sub array sum is " + maxSum);
    }
}
