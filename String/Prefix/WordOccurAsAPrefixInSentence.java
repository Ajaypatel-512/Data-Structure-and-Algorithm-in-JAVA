package String.Prefix;

import java.util.Arrays;

public class WordOccurAsAPrefixInSentence {

    /**
     * 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
     *
     * Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
     *
     * Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
     *
     * A prefix of a string s is any leading contiguous substring of s.
     *
     *
     *
     * Example 1:
     *
     * Input: sentence = "i love eating burger", searchWord = "burg"
     * Output: 4
     * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
     * Example 2:
     *
     * Input: sentence = "this problem is an easy problem", searchWord = "pro"
     * Output: 2
     * Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
     * Example 3:
     *
     * Input: sentence = "i am tired", searchWord = "you"
     * Output: -1
     * Explanation: "you" is not a prefix of any word in the sentence.
     *
     *
     * Constraints:
     *
     * 1 <= sentence.length <= 100
     * 1 <= searchWord.length <= 10
     * sentence consists of lowercase English letters and spaces.
     * searchWord consists of lowercase English letters.
     * */

    public static void main(String[] args) {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        System.out.println(isPrefixOfWord3(sentence,searchWord));
    }


    //Solution 1 Brute Force
    //T.C : O(n) where n = number of word in sentence
    //S.C : O(1)
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i=0; i<words.length; i++){
            if (words[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }

    //Solution 2 With Using Built-In Method
    //T.C : O(n) where n = number of word in sentence
    //S.C : O(1)
    public static int isPrefixOfWord2(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int m = searchWord.length();
        int n = words.length;
        for (int i=0; i<n; i++){
            if (words[i].length() >= searchWord.length()){
                if(words[i].substring(0,m).equals(searchWord)){
                    return i+1;
                }
            }
        }
        return -1;
    }

    //Solution 3 Without Using Built-In Method
    //T.C : O(n) where n = number of word in sentence
    //S.C : O(1)
    public static int isPrefixOfWord3(String sentence, String searchWord) {
        int m = searchWord.length();
        int n = sentence.length();
        int i=0;
        int j=0;
        int index=1;
       while(i<n){
            while (i<n && sentence.charAt(i) == ' '){
                i++;
            }
           while (i<n && j<m && sentence.charAt(i) == searchWord.charAt(j)){
               i++;
               j++;
           }
           if (j==m){
               return index;
           }
           j=0;
           while (i<n && sentence.charAt(i) != ' '){
               i++;
           }
           i+=1;
           index++;
        }
        return -1;
    }
}
