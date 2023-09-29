package arrays;

/**
 * Given an array prices[] of length N, representing the prices of the stocks on different days,
 * the task is to find the maximum profit possible for buying and selling the stocks on different days using transactions
 * where at most one transaction is allowed.
 * Note: Stock must be bought before being sold.
 *
 * Input: prices[] = {7, 1, 5, 3, 6, 4}
 * Output: 5
 * Explanation:
 * The lowest price of the stock is on the 2nd day, i.e. price = 1. Starting from the 2nd day, the highest price of the stock is witnessed on the 5th day, i.e. price = 6.
 * Therefore, maximum possible profit = 6 – 1 = 5.
 *
 * Input: prices[] = {7, 6, 4, 3, 1}
 * Output: 0
 * Explanation: Since the array is in decreasing order, no possible way exists to solve the problem
 */
public class _13_StockBuyAndSellSingleTime {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        findMaxProfit(arr);
    }

    //TC is O(N)
    //SC is O(1)
    private static void findMaxProfit(int[] arr) {
        //idea is to buy a stock at i index then try to sell it and find the max profit
        int maxProfit = 0;
        int minSoFar = arr[0];
        for (int i = 0; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);
            if (arr[i] >= minSoFar) {
                maxProfit = Math.max(maxProfit, (arr[i] - minSoFar));
            }
        }
        System.out.println("Max profit earned is : " + maxProfit);
    }
}
