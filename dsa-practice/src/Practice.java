import java.util.Stack;
//654
public class Practice {
//4567 123
    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;
        findSubArray(arr, sum);
    }

    private static void findSubArray(int[] arr, int sum) {
        int start = 0;
        int currSum = 0;
        for (int i =0; i < arr.length;i++) {
            currSum = currSum + arr[i];
            while (currSum > sum && start < arr.length) {
                currSum = currSum - arr[start];
                start++;
            }
            if (currSum == sum) {
                System.out.println("Sub array found at indexes : " + start + ", " + i);
                break;
            }
        }
    }
}