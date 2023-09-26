package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are
 * consecutive integers, the consecutive numbers can be in any order.
 * nput: arr[] = {1, 9, 3, 10, 4, 20, 2}
 * Output: 4
 * Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements
 *
 * Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
 * Output: 5
 * Explanation: The subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.
 */
public class _11_LongestSubSequenceInArray {

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        findLongestSubSequence(arr);
    }

    // TC is O(N)
    //SC is O(N)
    private static void findLongestSubSequence(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int i : arr) {
            numSet.add(i);//removes all duplicates
        }

        int longestSubSeq = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!numSet.contains(arr[i] - 1)) {
                int currentLongest = 1;
                int currentNum = arr[i];

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLongest++;
                }
                longestSubSeq = Math.max(longestSubSeq, currentLongest);
            }
        }
        System.out.println("Longest sub sequence length is : " + longestSubSeq);
    }
}
