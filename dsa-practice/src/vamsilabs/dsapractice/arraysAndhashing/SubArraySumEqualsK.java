package vamsilabs.dsapractice.arraysAndhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubArraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,1,1};// 0 1 2 3
        int k = 2;
        System.out.println(subarraySumEfficient(nums, k));
    }

    //TC is O (n ^2 ) and sc is O(1)
    private static int subarraySumBrute(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //TC is O(n) and SC is O(n)
    private static int subarraySumEfficient(int[] nums, int k) {
        //we put the occurrences of the prefix sum in map as value {0=1, 1=1, 2=1, 3=1}
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum = currentSum + num;
            count = count + prefixSum.getOrDefault(currentSum - k, 0);
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
