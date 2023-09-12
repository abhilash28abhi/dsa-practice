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
        System.out.println("Min element using recursion is : " + findMinUsingRecursion(arr, 0 , arr.length));
        System.out.println("Max element using recursion is : " + findMaxUsingRecursion(arr, 0 , arr.length));
    }

    //O(NlogN)
    private static void findMaxMin(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Min element is : " + arr[0]);
        System.out.println("Max element is : " + arr[arr.length - 1]);
    }

    // O(N) TC
    // O(N) SC since recursion will be using the stack
    private static int findMinUsingRecursion (int[] arr, int i , int n) {
        //i is the index starting from 0
        return n == 1 ? arr[i] : Math.min(arr[i], findMinUsingRecursion(arr, i + 1, n - 1));
    }

    private static int findMaxUsingRecursion (int[] arr, int i , int n) {
        //i is the index starting from 0
        return n == 1 ? arr[i] : Math.max(arr[i], findMaxUsingRecursion(arr, i + 1, n - 1));
    }
}
