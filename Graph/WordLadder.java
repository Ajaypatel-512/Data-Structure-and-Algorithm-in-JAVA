package Graph;

import java.util.*;

public class WordLadder {
    /**
     * 127. Word Ladder
     * Hard
     * Topics
     * premium lock icon
     * Companies
     * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
     *
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
     * sk == endWord
     * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
     *
     *
     *
     * Example 1:
     *
     * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     * Output: 5
     * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
     * Example 2:
     *
     * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
     * Output: 0
     * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
     *
     *
     * Constraints:
     *
     * 1 <= beginWord.length <= 10
     * endWord.length == beginWord.length
     * 1 <= wordList.length <= 5000
     * wordList[i].length == beginWord.length
     * beginWord, endWord, and wordList[i] consist of lowercase English letters.
     * beginWord != endWord
     * All the words in wordList are unique.
     * */
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(ladderLength(beginWord, endWord, Arrays.stream(wordList).toList()));
    }
    static class Pair {
        String first;
        int second;
        Pair(String _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    //Solution 1: BFS
    //Time Complexity: O(N * M * 26) where N is the number of words in the word list and M is the length of each word.
    //Space Complexity: O(N) for the queue and the set.
    public static int ladderLength(String startWord, String targetWord, List<String> wordLists) {
            String[] wordList = new String[wordLists.size()];
            for (int i = 0; i < wordLists.size(); i++) {
                wordList[i] = wordLists.get(i);
            }
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(startWord, 1));
            Set<String> st = new HashSet<String>();
            int len = wordList.length;
            for (int i = 0; i < len; i++) {
                st.add(wordList[i]);
            }
            st.remove(startWord);
            while (!q.isEmpty()) {
                String word = q.peek().first;
                int steps = q.peek().second;
                q.remove();
                if (word.equals(targetWord) == true) return steps;
                // word = hot
                for (int i = 0; i < word.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char replacedCharArray[] = word.toCharArray();
                        replacedCharArray[i] = ch;
                        String replacedWord = new String(replacedCharArray);
                        // it exists in the set
                        if (st.contains(replacedWord) == true) {
                            st.remove(replacedWord);
                            q.add(new Pair(replacedWord, steps + 1));
                        }
                    }
                }
            }
            return 0;
        }
}
