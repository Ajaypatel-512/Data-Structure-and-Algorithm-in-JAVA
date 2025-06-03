package Binary_Search;

public class MinimumNumberOfDaysToMakeMBouquets {
    /**
     * 1482. Minimum Number of Days to Make m Bouquets
     * You are given an integer array bloomDay, an integer m and an integer k.
     *
     * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
     *
     * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
     *
     * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
     * Output: 3
     * Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
     * We need 3 bouquets each should contain 1 flower.
     * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
     * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
     * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
     * Example 2:
     *
     * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
     * Output: -1
     * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
     * Example 3:
     *
     * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
     * Output: 12
     * Explanation: We need 2 bouquets each should have 3 flowers.
     * Here is the garden after the 7 and 12 days:
     * After day 7: [x, x, x, x, _, x, x]
     * We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
     * After day 12: [x, x, x, x, x, x, x]
     * It is obvious that we can make two bouquets in different ways.
     *
     *
     * Constraints:
     *
     * bloomDay.length == n
     * 1 <= n <= 105
     * 1 <= bloomDay[i] <= 109
     * 1 <= m <= 106
     * 1 <= k <= n
     * */
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k)); // Output: 3

        bloomDay = new int[]{1, 10, 3, 10, 2};
        m = 3;
        k = 2;
        System.out.println(minDays(bloomDay, m, k)); // Output: -1

        bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
        m = 2;
        k = 3;
        System.out.println(minDays(bloomDay, m, k)); // Output: 12
    }

    //Solution 1: Brute force
    //Time Complexity: O(n * (max - min))
    //Space Complexity: O(1)
    public static int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; // Size of the array
        if (val > n) return -1; // Impossible case.
        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        for (int i = mini; i <= maxi; i++) {
            if (possible(bloomDay, i, m, k))
                return i;
        }
        return -1;
    }

    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int count = 0;
        int noOfBouquets = 0;

        for(int i=0; i<n; i++){
            if (arr[i] <= day){
                count++;
            } else {
                noOfBouquets += count / k;
                count = 0;
            }
        }
        noOfBouquets += count / k;
        return noOfBouquets >= m;
    }

    //Solution 2: Binary Search
    // Time Complexity: O(n * log(max - min))
    // Space Complexity: O(1)
    public static int minDaysBinarySearch(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length; // Size of the array
        if (val > n) return -1; // Impossible case.

        // Find maximum and minimum:
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int left = mini, right = maxi;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(bloomDay, mid, m, k)) {
                right = mid; // Try to find a smaller day
            } else {
                left = mid + 1; // Increase the day
            }
        }
        return left;
    }
}
