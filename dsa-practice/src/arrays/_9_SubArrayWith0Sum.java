package arrays;

/**
 * Given an array of positive and negative numbers,
 * the task is to find if there is a subarray (of size at least one) with 0 sum.
 *
 * Input: {4, 2, -3, 1, 6}
 * Output: true
 * Input: {4, 2, 0, 1, 6}
 * Output: true
 */
public class _9_SubArrayWith0Sum {

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        findIfSubArrayExists(arr, 0);
    }

    // we will use the sliding window concept to solve this
    // TC is O(n)
    //SC is O(1)
    private static void findIfSubArrayExists(int[] arr, int sum) {
        int startIndex = 0;

        int subArraySum = arr[0];
        boolean existsFlag = false;
        for (int i = 1; i < arr.length; i++) {
            subArraySum += arr[i];

            //to remove elements from the window
            while (subArraySum > sum && startIndex < i) {
                subArraySum = subArraySum - arr[startIndex];
                startIndex++;
            }

            if (subArraySum == sum) {
                existsFlag = true;
                break;
            }
        }
        if (existsFlag) {
            System.out.println("Sub array with sum 0 exists");
        } else {
            System.out.println("Sub array with sum 0 doesn't exists");
        }
    }
}
