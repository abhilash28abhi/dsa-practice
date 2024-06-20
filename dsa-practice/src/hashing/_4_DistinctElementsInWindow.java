package hashing;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given an array of size N and an integer K, return the count of distinct numbers in all windows of size K.
 * Input: arr[] = {1, 2, 1, 3, 4, 2, 3}, K = 4
 * Output: 3 4 4 3
 * Explanation: First window is {1, 2, 1, 3}, count of distinct numbers is 3.
 *              Second window is {2, 1, 3, 4} count of distinct numbers is 4.
 *              Third window is {1, 3, 4, 2} count of distinct numbers is 4.
 *              Fourth window is {3, 4, 2, 3} count of distinct numbers is 3.
 *
 * Input: arr[] = {1, 2, 4, 4}, K = 2
 * Output: 2 2 1
 */
public class _4_DistinctElementsInWindow {

    public static void main(String[] args) {
        int[] input = {1, 2, 1, 3, 4, 2, 3};
        countDistinctElements(input, 4);
    }

    //TC is O(n - k) * O(k)
    //SC is O(k)
    private static void countDistinctElements(int[] input, int k) {
        //idea is to have a window of size k and get the distinct elements count in that window
        for (int i = 0 ; i <= input.length - k; i++) {
            int j = i;
            Set<Integer> distinctElements = new TreeSet<>();
            while (j < i + k) {
                distinctElements.add(input[j]);
                j++;
            }
            System.out.println(distinctElements.size());
        }
    }
}
