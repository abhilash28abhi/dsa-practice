package vamsilabs.dsapractice.arraysAndhashing;


import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelfEfficient(nums);
        System.out.println(Arrays.toString(result));
    }

    //TC is O(n^2) and SC is O(n)
    private static int[] productExceptSelfBrute(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int res = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    res = res * nums[j];
                }
            }
            answer[i] = res;
        }
        return answer;
    }

    private static int[] productExceptSelfEfficient(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Calculate the prefix products
        int res = 1;
        answer[0] = res;
        for (int i = 1; i < n; i++) {
            res = res * nums[i - 1];
            answer[i] = res;
        }
        //1 1 2 6 --> left pass
        // Calculate the suffix products and multiply with the prefix products
        int suffixProduct = 1;
        for (int i = 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }

        return answer;
    }
}
