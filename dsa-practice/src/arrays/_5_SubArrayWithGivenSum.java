package arrays;

/**
 * Given an array arr[] of non-negative integers and an integer sum, find a subarray that adds to a given sum.
 * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 * Output: Sum found between indexes 2 and 4
 *
 * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 * Output: Sum found between indexes 1 and 4
 */
public class _5_SubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        findSubArray(arr, sum);
    }

    //using sliding window concept this can be solved in O(n)
    // TC O(n)
    // SC O(1)
    private static void findSubArray(int[] arr, int sum) {
        int startIndex = 0;
        int subArraySum = arr[0];

        for (int endIndex = 1; endIndex < arr.length; endIndex++) {
            subArraySum += arr[endIndex];

            //once the current sub array sum is greater than the sum, remove elements from start index
            while (subArraySum > sum && startIndex <= endIndex) {
                subArraySum = subArraySum - arr[startIndex];
                startIndex++;
            }

            if (subArraySum == sum) {
                System.out.println("Sub array found at indexes : " + startIndex + ", " + endIndex);
                break;
            }
        }
    }
}
