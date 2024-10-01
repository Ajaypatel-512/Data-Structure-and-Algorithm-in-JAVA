package Map_Interface.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckIfArrayPairsAreDivisibleByK {

    /**
     * 1497. Check If Array Pairs Are Divisible by k
     *
     * Given an array of integers arr of even length n and an integer k
     * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
     *
     * Return true If you can find a way to do that or false otherwise.
     *
     * Example 1:
     *
     * Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
     * Output: true
     * Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
     * Example 2:
     *
     * Input: arr = [1,2,3,4,5,6], k = 7
     * Output: true
     * Explanation: Pairs are (1,6),(2,5) and(3,4).
     * Example 3:
     *
     * Input: arr = [1,2,3,4,5,6], k = 10
     * Output: false
     * Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.
     *
     * Input: arr [10,15,20,30], k=5
     * Output: true
     * Explanation: Edge case here remainder 0 = 4
     * if remainder 0 frequency is odd then answer would be false
     * */

    /*
    * 1.  Find remainder (x%k) and store in map
    * 2. if(map.get(0) % 2 != 0) return false;
    * 3.  iterate in remainders for (rem = 1, rem <= k/2)   check only for k<=2
    * 4. counter half = k - remainder
    * 5. if (map.get(counterHalf) != map.get(remainder)) return false
    * 6.
    * */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        System.out.println(canArrange1(arr,k));
        System.out.println(canArrange2(arr,k));
    }

    // 1st Solution
    public static boolean canArrange1(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x: arr) {
            int rem = x%k; // for positive value
            // int rem = (x%k + k) % k; // for negative value
            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        if(map.get(0) %2 != 0){
            return false;
        }

        for (int rem = 1; rem <=k/2; rem++){
            int counterHalf = k-rem;
            if(map.get(counterHalf) != map.get(rem)){
                return false;
            }
        }
        return true;
    }

    // 2nd Solution
    public static boolean canArrange2(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x: arr) {
            //int rem = x%k; // for positive value
            int rem = (x%k + k) % k; // for negative value
            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        for(int x : arr){
            int rem = (x%k+k)%k;
            if(rem==0) {
                if(map.get(rem)%2==1){
                    return false;
                }
                continue;
            }

            Integer p = map.get(rem) ;
            Integer q = map.get(k-rem);
            if(!Objects.equals(p, q))
                return false;
        }

        return true;
    }
}
