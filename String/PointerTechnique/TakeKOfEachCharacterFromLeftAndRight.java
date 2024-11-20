package String.PointerTechnique;

public class TakeKOfEachCharacterFromLeftAndRight {

    /**
     * 2516. Take K of Each Character From Left and Right
     * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.
     *
     * Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aabaaaacaabc", k = 2
     * Output: 8
     * Explanation:
     * Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
     * Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
     * A total of 3 + 5 = 8 minutes is needed.
     * It can be proven that 8 is the minimum number of minutes needed.
     * Example 2:
     *
     * Input: s = "a", k = 1
     * Output: -1
     * Explanation: It is not possible to take one 'b' or 'c' so return -1.
     * */
    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(s,k));
    }

    //Solution 1 Using 2 pointer
    //T.C : O(n)
    //S.C : O(1)
    public static int takeCharacters(String s, int k) {
        if (k == 0){
            return 0;
        }
        int[] count = new int[3];
        int left = 0, right = s.length()-1;

        while (right >= 0){
            count[s.charAt(right) - 'a']++;
            if (count[0] >= k && count[1] >= k && count[2] >= k){
                break;
            }
            right--;
        }

        if (count[0] < k || count[1] < k || count[2] < k){
            return -1;
        }

        int res = s.length()-right;
        while (left < s.length()){
            count[s.charAt(left) - 'a']++;
            while (right < s.length() && count[s.charAt(right) - 'a'] > k){
                count[s.charAt(right) - 'a']--;
                ++right;
            }
            res = Math.min(res,left+s.length() - right+1);
            left++;
        }
        return  res;
    }

}
