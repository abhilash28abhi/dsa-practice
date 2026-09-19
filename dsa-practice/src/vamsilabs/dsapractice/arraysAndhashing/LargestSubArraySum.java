package vamsilabs.dsapractice.arraysAndhashing;


/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class LargestSubArraySum {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = findLargestSubArraySumKadane(nums);
        System.out.println("Max Sum of SubArray is: " + maxSum);
    }

    //TC is O(n^2) and SC is O(1)
    private static int findLargestSubArraySumBrute (int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0 ; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length ; j++) {
                currentSum = currentSum + nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    private static int findLargestSubArraySumKadane(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0 ; i < nums.length; i++) {
            currentSum = currentSum + nums[i];

            if (currentSum >= maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
