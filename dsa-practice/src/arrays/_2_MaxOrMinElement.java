package arrays;

import java.util.Arrays;

/**
 * Given an array, write functions to find the minimum and maximum elements in it.
 *  Input arr : {1,2,3,4,5,6}
 *  Min is 1, Max is 6
 */
public class _2_MaxOrMinElement {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        findMaxMin(arr);
    }

    //O(NlogN)
    private static void findMaxMin(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Min element is : " + arr[0]);
        System.out.println("Max element is : " + arr[arr.length - 1]);
    }
}
