package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers of size N, the task is to find the first non-repeating element in this array.
 *
 * Input: {-1, 2, -1, 3, 0}
 * Output: 2
 * Explanation: The first number that does not repeat is : 2
 *
 * Input: {9, 4, 9, 6, 7, 4}
 * Output: 6
 */
public class _8_FindFirstNonRepeatingElement {

    public static void main(String[] args) {
        int[] arr = {-1, 2, -1, 3, 0};
        findFirstNonRepeating(arr);
    }

    // TC is O(n)
    //SC is O(n)
    private static void findFirstNonRepeating(int[] arr) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!lookup.containsKey(arr[i])) {
                //its not a duplicate
                lookup.put(arr[i], 1);
            } else {
                //duplicate exists so increment the count
                lookup.put(arr[i], lookup.get(arr[i]) + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (lookup.get(arr[i]) == 1) {
                System.out.println("First non repeating element is : " + arr[i]);
                break;
            }
        }
    }
}
