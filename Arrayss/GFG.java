package Arrayss;
import java.util.HashMap;

class GFG {

    public static int longestSubsequence(int[] arr, int K) {

        // Stores length of longest
        // subsequence in a map
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Variable to store the maximum
        // length of subsequence
        int mx = 1;

        // Loop to iterate through the
        // given array
        for (int x : arr) {
            mp.put(x, 1);

            // If (x - K) exists
            if (mp.containsKey(x - K)) {
                mp.put(x, 1 + mp.get(x - K));
            }

            // If (x + K) exists
            if (mp.containsKey(x + K)) {
                mp.put(x, Math.max(mp.get(x), 1 + mp.get(x + K)));
            }
            mx = Math.max(mx, mp.get(x));
        }

        // Return Answer
        return mx+1;
    }

    // Driver Code
    public static void main(String args[]) {
        int[] arr = { 1,3,1,4,5,7,10 };
        int K = 2;

        System.out.print(longestSubsequence(arr, K));
    }
}
