package arrays;

import java.util.Arrays;

/**
 * Given an array, the task is to cyclically rotate the array clockwise by one time.
 * Input: arr[] = {1, 2, 3, 4, 5}
 * Output: arr[] = {5, 1, 2, 3, 4}
 *
 * Input: arr[] = {2, 3, 4, 5, 1}
 * Output: {1, 2, 3, 4, 5}
 */
public class _6_RotateAnArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        rotateAnArray(arr, n);
    }

    //swap every element with the last element of array till we reach the end
    // TC is O(N)
    private static void rotateAnArray(int[] arr, int n) {
        int lastElement = arr[n - 1];
        for (int i = 0; i < n ; i++) {
            int temp = arr[i];
            arr[i] = lastElement;
            lastElement = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
