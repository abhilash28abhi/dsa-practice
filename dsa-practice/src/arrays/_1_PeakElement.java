package arrays;

/**
 * Given an array arr of n elements that is first strictly increasing and then maybe strictly decreasing,
 * find the maximum element in the array.
 * Note: If the array is increasing then just print the last element will be the maximum value.
 * Input: array[]= {5, 10, 20, 15}
 * Output: 20
 * Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.
 *
 * Input: array[] = {10, 20, 15, 2, 23, 90, 67}
 * Output: 20 or 90
 */
public class _1_PeakElement {

    public static void main(String[] args) {
        int arr[] = {10, 20, 15, 2, 23, 90, 67};
        findPeakElement(arr);
    }

    //O(N)
    private static void findPeakElement(int[] arr) {
        if (arr.length == 1) {
            System.out.println("Peak element is : " + arr[0]);
        }
        if (arr[0] > arr[1]) {
            System.out.println("Peak element is : " + arr[0]);
        }

        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            System.out.println("Peak element is : " + arr[arr.length - 1]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] >= arr[i+1]) {
                System.out.println("Peak element is : " + arr[i]);
            }
        }

    }
}
