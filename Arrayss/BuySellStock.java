package Arrayss;

public class BuySellStock {
    /**
     * 121. Best Time to Buy and Sell Stock
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * Example 2:
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     *
     * Constraints:
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     * */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    //Solution 1: Brute Force Approach
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;

        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    //Solution 2: Optimal Approach
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            minPrice = Math.min(minPrice, prices[i]);
            max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }


}
