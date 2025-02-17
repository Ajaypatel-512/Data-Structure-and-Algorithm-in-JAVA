package Backtracking;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    /**
     * 1079. Letter Tile Possibilities
     * You have n  tiles, where each tile has one letter tiles[i] printed on it.
     *
     * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
     *
     *
     *
     * Example 1:
     *
     * Input: tiles = "AAB"
     * Output: 8
     * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
     * Example 2:
     *
     * Input: tiles = "AAABBC"
     * Output: 188
     * Example 3:
     *
     * Input: tiles = "V"
     * Output: 1
     *
     *
     * Constraints:
     *
     * 1 <= tiles.length <= 7
     * tiles consists of uppercase English letters.
     * */
    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }

    static int n;
    //Solution 1 : Using Backtracking
    //Time Complexity : O(n!)
    //Space Complexity : O(n*n! + n) where n is the length of the string
    public static int numTilePossibilities(String tiles) {
        //Do Something
        //Explore the possibility , store ans
        //undo
        n = tiles.length();
        boolean visited[] = new boolean[n];
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        solve(tiles, visited, set, sb);
        return set.size()-1;
    }

    private static void solve(String tiles, boolean[] used, Set<String> result, StringBuilder curr) {
        result.add(curr.toString());

        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;

            // Choose the tile at index i
            curr.append(tiles.charAt(i));
            used[i] = true;

            // Explore further with this choice
            solve(tiles, used, result, curr);

            // Backtrack: remove the tile and mark it unused
            used[i] = false;
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
