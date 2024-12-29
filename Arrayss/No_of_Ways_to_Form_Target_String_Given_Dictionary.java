package Arrayss;

public class No_of_Ways_to_Form_Target_String_Given_Dictionary {
    /**
     * 1639. Number of Ways to Form a Target String Given a Dictionary
     * You are given a list of strings of the same length words and a string target.
     *
     * Your task is to form target using the given words under the following rules:
     *
     * target should be formed from left to right.
     * To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
     * Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. In other words, all characters to the left of or at index k become unusuable for every string.
     * Repeat the process until you form the string target.
     * Notice that you can use multiple characters from the same string in words provided the conditions above are met.
     *
     * Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["acca","bbbb","caca"], target = "aba"
     * Output: 6
     * Explanation: There are 6 ways to form target.
     * "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
     * "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
     * "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
     * "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
     * "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
     * "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
     * Example 2:
     *
     * Input: words = ["abba","baab"], target = "bab"
     * Output: 4
     * Explanation: There are 4 ways to form target.
     * "bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
     * "bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
     * "bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
     * "bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 1000
     * 1 <= words[i].length <= 1000
     * All strings in words have the same length.
     * 1 <= target.length <= 1000
     * words[i] and target contain only lowercase English letters.
     * */
    public static void main(String[] args) {
        String[] words = {"acca","bbbb","caca"};
        String target = "aba";
        System.out.println(numWays(words, target));
    }

    //Recursive solution
    //Time complexity: O(n*m) where n is the length of words and m is the length of target
    //Space complexity: O(n*m)
    public static int numWays(String[] words, String target) {
        int wordLen = words[0].length();
        int targetLen = target.length();
        int charFreq[][] = new int[wordLen][26];
        for(String word : words){
            for(int i=0;i<word.length();i++){
                int charIndex = word.charAt(i) - 'a';
                charFreq[i][charIndex]++;
            }
        }
        return (int)recur(0,0,charFreq, target, words);
    }

    static long recur(int wordIndex, int targetIndex, int charFreq[][], String target, String words[]){
        if(targetIndex == target.length()){
            return 1;
        }
        if(wordIndex == words[0].length()){
            return 0;
        }
        if((target.length() - targetIndex) > (words[0].length() - wordIndex)){
            return 0;
        }

        int curIndex = target.charAt(targetIndex) - 'a';
        int freq = charFreq[wordIndex][curIndex];

        long pick = freq * recur(wordIndex+1, targetIndex+1,charFreq,target,words);
        long noPick = recur(wordIndex+1, targetIndex,charFreq,target,words);
        long res = (pick + noPick)%1000000007;
        return res;

    }


    //DP solution
    //Time complexity: O(n*m) where n is the length of words and m is the length of target
    //Space complexity: O(n*m)
    public static int numWays2(String[] words, String target) {
        int wordLen = words[0].length();
        int targetLen = target.length();
        int charFreq[][] = new int[wordLen][26];

        for(String word : words){
            for(int i=0;i<word.length();i++){
                int charIndex = word.charAt(i) - 'a';
                charFreq[i][charIndex]++;
            }
        }
        long dp[][] = new long[wordLen+1][targetLen+1];

        //base cases
        for(int i=0;i<wordLen+1;i++){
            dp[i][targetLen] = 1;
        }

        for(int i=wordLen-1;i>=0;i--){
            for(int j=targetLen-1;j>=0;j--){
                int curIndex = target.charAt(j) - 'a';
                int freq = charFreq[i][curIndex];
                long pick = freq * dp[i+1][j+1]; //recur(i+1, j+1,charFreq,target,words, dp);
                long noPick = dp[i+1][j]; //recur(i+1, j,charFreq,target,words, dp);
                long res = (pick + noPick)%1000000007;
                dp[i][j] = res;
            }
        }
        return (int) dp[0][0];//recur(0,0,charFreq, target, words, dp);
    }
}
