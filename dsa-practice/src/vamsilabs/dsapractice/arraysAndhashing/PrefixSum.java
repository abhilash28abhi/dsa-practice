package vamsilabs.dsapractice.arraysAndhashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array {2,4,1,3,9} return the sum of sub array from index 1 to 3 result is 8
 */
public class PrefixSum {

    public static void main(String[] args) {
        int[] nums = {2,4,1,3,9};
        System.out.println("Prefix sum for index 1 to 3 is " + findPrefixSum(nums, 1, 3));
    }

    private static int findPrefixSum(int[] nums, int start, int end) {
        List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(0);

        int currentSum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            prefixSum.add(currentSum);
        }
        //0,2,6,7,10,19
        return prefixSum.get(end + 1) - prefixSum.get(start);
    }
}
