package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array with repeated elements, the task is to find the maximum distance between two occurrences of an element
 *
 * Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
 * Output: 10
 * // maximum distance for 2 is 11-1 = 10
 * // maximum distance for 1 is 4-2 = 2
 * // maximum distance for 4 is 10-5 = 5
 */
public class _2_MaximumDistanceBetweenElements {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println("Maximum distance between 2 occurrences of an element is : " + maxDistance(arr));
    }

    //TC is O(N)
    //SC is O(M), M is the no of distinct elements in array
    private static int maxDistance(int[] arr) {
        //store the last index of each element
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            lookup.put(arr[i], i);
        }
        int maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (lookup.containsKey(arr[i])) {
                maxDistance = Math.max((lookup.get(arr[i]) - i), maxDistance);
            }
        }
        return maxDistance;
    }
}
