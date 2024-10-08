package String.PointerTechnique;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringSimillarity3 {

    /**
     * 1813. Sentence Similarity III
     *
     * You are given two strings sentence1 and sentence2, each representing a sentence composed of words. A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of only uppercase and lowercase English characters.
     *
     * Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be separated from existing words by spaces.
     *
     * For example,
     *
     * s1 = "Hello Jane" and s2 = "Hello my name is Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in s1.
     * s1 = "Frog cool" and s2 = "Frogs are cool" are not similar, since although there is a sentence "s are" inserted into s1, it is not separated from "Frog" by a space.
     * Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.
     *
     * Example 1:
     *
     * Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
     *
     * Output: true
     *
     * Explanation:
     *
     * sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
     *
     * Example 2:
     *
     * Input: sentence1 = "of", sentence2 = "A lot of words"
     *
     * Output: false
     *
     * Explanation:
     *
     * No single sentence can be inserted inside one of the sentences to make it equal to the other.
     *
     * Example 3:
     *
     * Input: sentence1 = "Eating right now", sentence2 = "Eating"
     *
     * Output: true
     *
     * Explanation:
     *
     * sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
     * */

    public static void main(String[] args) {
//        System.out.println(areSentencesSimilar1("My roy","My name is roy"));

        System.out.println(areSentencesSimilar2("My roy","My name is roy"));
    }

    //SOLUTION 1 - 2 pointer approach O(s1Len + s2Len)
    public static boolean areSentencesSimilar1(String sentence1, String sentence2) {
        int s1Len = sentence1.length();
        int s2Len = sentence2.length();

        if (s1Len < s2Len){
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }

        String[] stringS1 = sentence1.split(" ");
        String[] stringS2 = sentence2.split(" ");

        int i = 0;
        int j = stringS1.length-1;

        int k = 0;
        int l = stringS2.length-1;

        while(k < stringS2.length && i < stringS1.length && stringS2[k].equals(stringS1[i])) {
            k++;
            i++;
        }
        while(l >= k && stringS2[l].equals(stringS1[j])) {
            j--;
            l--;
        }

        return l < k;
    }

    //SOLUTION 2 - 2 pointer approach O(number of words in shorter string)
    public static boolean areSentencesSimilar2(String sentence1, String sentence2) {
        int s1Len = sentence1.length();
        int s2Len = sentence2.length();

        if (s1Len < s2Len){
            String temp = sentence1;
            sentence1 = sentence2;
            sentence2 = temp;
        }

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        Deque<String> deque1 = new ArrayDeque<>();
        Deque<String> deque2 = new ArrayDeque<>();

        // Add words from sentences to deques
        for (String word : words1) {
            deque1.addLast(word);
        }

        for (String word : words2) {
            deque2.addLast(word);
        }

        while(!deque2.isEmpty() && !deque1.isEmpty() && deque2.peekFirst().equals(deque1.peekFirst())){
            deque2.removeFirst();
            deque1.removeFirst();
        }

        while(!deque2.isEmpty() && !deque1.isEmpty() && deque2.peekLast().equals(deque1.peekLast())){
            deque2.removeLast();
            deque1.removeLast();
        }

        return deque2.isEmpty();
    }

}
