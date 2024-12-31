package Arrayss;

import java.util.Arrays;
import java.util.HashSet;

public class MinCostForTicket {
    /**
     * 983. Minimum Cost For Tickets
     * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
     *
     * Train tickets are sold in three different ways:
     *
     * a 1-day pass is sold for costs[0] dollars,
     * a 7-day pass is sold for costs[1] dollars, and
     * a 30-day pass is sold for costs[2] dollars.
     * The passes allow that many days of consecutive travel.
     *
     * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
     * Return the minimum number of dollars you need to travel every day in the given list of days.
     *
     *
     *
     * Example 1:
     *
     * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
     * Output: 11
     * Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
     * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
     * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
     * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
     * In total, you spent $11 and covered all the days of your travel.
     * Example 2:
     *
     * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
     * Output: 17
     * Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
     * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
     * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
     * In total, you spent $17 and covered all the days of your travel.
     *
     *
     * Constraints:
     *
     * 1 <= days.length <= 365
     * 1 <= days[i] <= 365
     * days is in strictly increasing order.
     * costs.length == 3
     * 1 <= costs[i] <= 1000
     * */
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets2(days, costs));
    }

    //Solution 1 : Using Recursion
    //Time Complexity : O(3^N)
    //Space Complexity : O(N)
    static HashSet<Integer> set = new HashSet<>();
    public static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1] + 30;
        int dp[] = new int[lastDay + 1];
        Arrays.fill(dp, -1);
        for (int day : days) {
            set.add(day);
        }
        return recur(dp, days, costs, days[0]);
        // return recur(days, costs, days[0]);
    }

    static int recur(int[] dp, int[] days, int[] costs, int currDay) {
        // int recur(int[] days, int[] costs, int currDay) {
        // base case
        if (currDay > days[days.length - 1]) {
            dp[currDay] = 0;
            return 0;
        }
        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        if (!set.contains(currDay)) {
            dp[currDay] = recur(dp, days, costs, currDay + 1);
            return dp[currDay];
            // return 0 + recur(days, costs, currDay + 1);
        }
        // int oneDay = costs[0] + recur( days, costs, currDay + 1);
        // int sevenDay = costs[1] + recur( days, costs, currDay + 7);
        // int thirtyDay = costs[2] + recur( days, costs, currDay + 30);
        // return Math.min(oneDay, Math.min(sevenDay, thirtyDay));

        int oneDay = costs[0] + recur(dp, days, costs, currDay + 1);
        int sevenDay = costs[1] + recur(dp, days, costs, currDay + 7);
        int thirtyDay = costs[2] + recur(dp, days, costs, currDay + 30);
        dp[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        return dp[currDay];
    }

    //Solution 2 : Using Recursion with Memoization
    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public static int mincostTickets2(int[] days, int[] costs) {
        for (int day : days) {
            set.add(day);
        }
        int lastDay = days[days.length - 1] + 30;
        int dp[] = new int[lastDay + 1];
        for(int day = days[days.length - 1]; day>=0; day--){
            if (!set.contains(day)) {
                dp[day] = dp[day + 1]; //recur(dp, days, costs, day + 1);
                continue;
            }
            int oneDay = costs[0] + dp[day+1]; //recur(dp, days, costs, day + 1);
            int sevenDay = costs[1] + dp[day+7]; //recur(dp, days, costs, day + 7);
            int thirtyDay = costs[2] + dp[day+30]; //recur(dp, days, costs, day + 30);
            dp[day] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }
        return dp[days[0]]; //recur(dp, days, costs, days[0]);
    }
}
