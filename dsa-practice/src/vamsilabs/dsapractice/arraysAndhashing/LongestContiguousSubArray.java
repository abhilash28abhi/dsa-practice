package vamsilabs.dsapractice.arraysAndhashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Example 3:
 *
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 */
public class LongestContiguousSubArray {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(findMaxLengthEfficient(nums));
    }

    //TC is O(n ^ 2) SC is O(1)
    private static int findMaxLengthBrute(int[] nums) {
        int maxLength = 0;

        for (int i = 0 ; i < nums.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count0++;
                } else {
                    count1++;
                }
                if (count0 == count1) {
                    maxLength = Math.max(maxLength, (j - i) + 1);
                }
            }
        }
        return maxLength;
    }

    //TC is O(n) and SC is O(n)
    private static int findMaxLengthEfficient(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        int prefixSum = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                prefixSum += -1;
            } else {
                prefixSum += 1;
            }

            if (map.containsKey(prefixSum)) {
                int previousIndex = map.get(prefixSum);
                int currentLength = i - previousIndex;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
