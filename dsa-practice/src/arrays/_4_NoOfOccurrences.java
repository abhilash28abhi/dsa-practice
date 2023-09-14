package arrays;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
 * Expected time complexity is O(Log N)
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
 * Output: 4
 *
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
 * Output: 1
 */
public class _4_NoOfOccurrences {

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        findCountOfOccurrences(arr, 2);
    }

    private static void findCountOfOccurrences(int[] arr, int x) {
        //find the start and end index for the required element using BS

        int startIndex = findStartIndex(arr, x);
        int lastIndex = findLastIndex(arr, x);

        int countOfOccurrences = (lastIndex - startIndex) + 1;
        System.out.println("Count of occurrences of element is : " + countOfOccurrences);
    }

    // O(log N)
    private static int findStartIndex (int[] arr, int x) {
        int startIndex = -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (x > arr[mid]) {
                start = mid + 1;
            } else if (x == arr[mid]) {
                startIndex = mid;
                end = mid - 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return startIndex;
    }

    private static int findLastIndex (int[] arr, int x) {
        int lastIndex = -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (x > arr[mid]) {
                start = mid + 1;
            } else if (x == arr[mid]) {
                lastIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return lastIndex;
    }
}
