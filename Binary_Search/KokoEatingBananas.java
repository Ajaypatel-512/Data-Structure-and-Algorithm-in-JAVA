package Binary_Search;

public class KokoEatingBananas {
    /**
     * 875. Koko Eating Bananas
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
     *
     * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
     *
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     *
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     *
     *
     *
     * Example 1:
     *
     * Input: piles = [3,6,7,11], h = 8
     * Output: 4
     * Example 2:
     *
     * Input: piles = [30,11,23,4,20], h = 5
     * Output: 30
     * Example 3:
     *
     * Input: piles = [30,11,23,4,20], h = 6
     * Output: 23
     *
     *
     * Constraints:
     *
     * 1 <= piles.length <= 104
     * piles.length <= h <= 109
     * 1 <= piles[i] <= 109
     * */
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h)); // Output: 4
    }

    //Solution 1: Linear Search
    //Time complexity: O(n*m), where n is the number of piles and m is the maximum number of bananas in a pile.
    //Space complexity: O(1)
    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int num: piles) {
            max = Math.max(max, num);
        }

        for (int i=1; i<=max; i++) {
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / i);
            }
            if (hours <= h) {
                return i;
            }
        }
        return 0;
    }

    //Solution 1: Binary Search
    //Time complexity: O(n * log(max)), where n is the number of piles and max is the maximum number of bananas in a pile.
    //Space complexity: O(1)
    public static int minEatingSpeed2(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int num: piles) {
            high = Math.max(high, num);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int totalH = calculateHours(piles, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int calculateHours(int[] piles, int mid) {
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / mid);
            }
            return hours;
    }
}
