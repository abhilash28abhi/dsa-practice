package hashing;

import java.util.HashSet;
import java.util.Set;

/**
 *Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. Both arrays are not in sorted order.
 * It may be assumed that elements in both arrays are distinct.
 *
 * Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
 * Output: arr2[] is a subset of arr1[]
 *
 * Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
 * Output: arr2[] is not a subset of arr1[]
 */
public class _1_FindArraySubsetOfArray {

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
        System.out.println("Is array2 subset of array1 ? : " + subsetOfArray(arr1, arr2));
    }

    //TC is O(N + M) == O(N), N is size of larger arr1
    //SC is O(M), where m is the size of smaller arr2
    private static boolean subsetOfArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (set.contains(arr1[i])) {
                count++;
            }
        }
        return count == set.size() ? true: false;
    }
}
