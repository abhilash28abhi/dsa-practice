package arrays;

/**
 * Given an integer array of coins[ ] of size N representing different types of denominations and an integer sum,
 * the task is to find the number of ways to make sum by using different denominations.
 * Note: Assume that you have an infinite supply of each type of coin.
 *
 * Input: sum = 4, coins[] = {1,2,3},
 * Output: 4
 * Explanation: there are four solutions: {1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}.
 *
 * Input: sum = 10, coins[] = {2, 5, 3, 6}
 * Output: 5
 * Explanation: There are five solutions:
 * {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 */
public class _15_CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        int count = findCountOfCoins(coins, sum);
        System.out.println("Total number of ways is : " + count);
    }

    //TC is O(N!)
    private static int findCountOfCoins(int[] coins, int sum) {
        //base condition
        if (sum == 0) {
            return 0;
        }

        for (int i = 0; i < coins.length; i++) {
            return findCountOfCoins(coins, sum - coins[i]) + 1;
        }
        return 0;
    }
}
