package String.Heap;

import java.util.PriorityQueue;

public class LongestHappyString {
    /**
     * 1405. Longest Happy String
     *
     * A string s is called happy if it satisfies the following conditions:
     *
     * s only contains the letters 'a', 'b', and 'c'.
     * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
     * s contains at most a occurrences of the letter 'a'.
     * s contains at most b occurrences of the letter 'b'.
     * s contains at most c occurrences of the letter 'c'.
     * Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
     *
     * A substring is a contiguous sequence of characters within a string.
     *
     * Example 1:
     *
     * Input: a = 1, b = 1, c = 7
     * Output: "ccaccbcc"
     * Explanation: "ccbccacc" would also be a correct answer.
     * Example 2:
     *
     * Input: a = 7, b = 1, c = 0
     * Output: "aabaa"
     * Explanation: It is the only correct answer in this case.
     * */

    public static void main(String[] args) {
        System.out.println(longestDiverseString(1,1,7));
    }

    //Solution 1 using heap O(log3)
    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        if (a > 0) maxHeap.offer(new int[]{a, 'a'});
        if (b > 0) maxHeap.offer(new int[]{b, 'b'});
        if (c > 0) maxHeap.offer(new int[]{c, 'c'});

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            char char1 = (char) first[1];

            if (res.length() > 1 && res.charAt(res.length() - 1) == char1 && res.charAt(res.length() - 2) == char1) {
                if (maxHeap.isEmpty()) break;

                int[] second = maxHeap.poll();
                char char2 = (char) second[1];
                res.append(char2);
                second[0]--;

                if (second[0] > 0) maxHeap.offer(second);
                maxHeap.offer(first);  // Put the first character back in the heap
            } else {
                res.append(char1);
                first[0]--;
                if (first[0] > 0) maxHeap.offer(first);
            }
        }
        return res.toString();
    }
}
