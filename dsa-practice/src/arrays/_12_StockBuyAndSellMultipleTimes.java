package arrays;

/**
 * The cost of a stock on each day is given in an array. Find the maximum profit that you can make by buying and selling
 * on those days. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 *
 * Input: arr[] = {100, 180, 260, 310, 40, 535, 695}
 * Output: 865
 * Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210
 *                        Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655
 *                        Maximum Profit  = 210 + 655 = 865
 *
 * Input: arr[] = {4, 2, 2, 2, 4}
 * Output: 2
 * Explanation: Buy the stock on day 1 and sell it on day 4 => 4 – 2 = 2
 *                        Maximum Profit  = 2
 */
public class _12_StockBuyAndSellMultipleTimes {

    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        findMaxStockProfit(arr);
    }

    //TC is O(N)
    //SC is O(1)
    private static void findMaxStockProfit(int[] arr) {
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                //means price has increased
                maxProfit = maxProfit + (arr[i] - arr[i - 1]);
            }
        }
        System.out.println("Max profit earned is : " + maxProfit);
    }
}
