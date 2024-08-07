package dynamicProgramming;

import java.util.Arrays;

/**
 * Given a positive integer K, the task is to find the minimum number of operations of the following two types, required to change 0 to K.
 *
 * Add one to the operand
 * Multiply the operand by 2.
 *
 * Input: K = 1
 * Output: 1
 * Explanation:
 * Step 1: 0 + 1 = 1 = K
 *
 * Input: K = 4
 * Output: 3
 * Explanation:
 * Step 1: 0 + 1 = 1,
 * Step 2: 1 * 2 = 2,
 * Step 3: 2 * 2 = 4 = K
 */
public class _1_MinimizeStepsToReachK {

    public static void main(String[] args) {
        int k = 12;
        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        System.out.println("Minimum steps required is : " + minimizeSteps(k, dp));
    }

    //SC is O(K)
    //TC is O(K)
    private static int minimizeSteps(int k, int[] dp) {
        if (k == 0) {
            return 0;
        }
        // Base case: 0 operations to reach 0
        dp[0] = 0;
        for (int i = 0; i < k; i++) {
            if (i + 1 <= k) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }

            if (i * 2 <= k) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
        }
        return dp[k];
    }
}
