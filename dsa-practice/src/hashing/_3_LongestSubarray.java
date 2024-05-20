package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arr[] containing n integers and a positive integer k. The problem is to find the longest subarray’s length
 * with the sum of the elements divisible by the given value k.
 *
 * Input: arr[] = {2, 7, 6, 1, 4, 5}, k = 3
 * Output: 4
 * Explanation: The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
 *
 * Input: arr[] = {-2, 2, -5, 12, -11, -1, 7}, k = 3
 * Output: 5
 */
public class _3_LongestSubarray {

    public static void main(String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        System.out.println("The longest sub array with sum divisible by k is : " + longestSubArray(arr, 3));
        System.out.println("The longest sub array with sum divisible by k is : " + longestSubArrayWithHashing(arr, 3));
    }

    //TC is O(N)
    //SC is O(N)
    private static int longestSubArrayWithHashing(int[] arr, int k) {
        Map<Integer, Integer> lookup = new HashMap<>();
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            int mod = (sum) % k;

            if (mod == 0) {
                maxLength = i + 1;
            }

            if (!lookup.containsKey(mod)) {
                lookup.put(mod, i);
            } else {
                int value = i - lookup.get(mod);
                maxLength = Math.max(maxLength, value);
            }
        }

        return maxLength;
    }

    //brute force approach is to find all the sub array with sum divisible by k
    //TC is O(N ^ 2)
    //SC is O(1)
    private static int longestSubArray(int[] arr, int k) {
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0 ; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum % k == 0) {
                    maxLength = Math.max(maxLength, (j - i) + 1);
                }
            }
        }
        return maxLength;
    }
}
