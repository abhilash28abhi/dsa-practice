package vamsilabs.dsapractice.arraysAndhashing;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveEfficient(nums)); // Output: 4
    }

    //TC is O(n log n) due to sorting and SC is O(n)
    private static int longestConsecutiveBrute(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //System.out.println(set);
        int count = 1;
        for (int i : set) {
            if (set.contains(i + 1)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    //TC is O(n) and SC is O(n)
    //If number-1 is NOT in the set, number is the start of a consecutive run, so count number, number+1, number+2... until missing.
    //If number-1 IS in the set, then number is inside a run that will be (or was) counted when you processed the smaller start — skip it.
    private static int longestConsecutiveEfficient(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int count = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int cur = 1, next = i + 1;
                while (set.contains(next)) {
                    cur++;
                    next++;
                }
                count = Math.max(count, cur);
            }
        }
        return count;
    }
}
