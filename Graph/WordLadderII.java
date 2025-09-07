package Graph;

import java.util.*;

public class WordLadderII {
    /**
     * 126. Word Ladder II
     * Hard
     * Topics
     * premium lock icon
     * Companies
     * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
     *
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
     * sk == endWord
     * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
     *
     *
     *
     * Example 1:
     *
     * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
     * Explanation: There are 2 shortest transformation sequences:
     * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
     * "hit" -> "hot" -> "lot" -> "log" -> "cog"
     * Example 2:
     *
     * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
     * Output: []
     * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
     *
     *
     * Constraints:
     *
     * 1 <= beginWord.length <= 5
     * endWord.length == beginWord.length
     * 1 <= wordList.length <= 500
     * wordList[i].length == beginWord.length
     * beginWord, endWord, and wordList[i] consist of lowercase English letters.
     * beginWord != endWord
     * All the words in wordList are unique.
     * The sum of all shortest transformation sequences does not exceed 105.
     * */
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(findLadders(beginWord, endWord, List.of(wordList)));
    }

    //Solution 1: BFS + DFS
    //Time Complexity: O(N * M^2) where N is the number of words in the wordList and M is the length of each word.
    //Space Complexity: O(N * M)
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return result;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Map to store parent-child relationships for path reconstruction
        Map<String, List<String>> parentMap = new HashMap<>();
        parentMap.put(beginWord, new ArrayList<>()); // Start node has no parents

        // Set to track visited nodes for the current level
        Set<String> visitedOnLevel = new HashSet<>();
        visitedOnLevel.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Set<String> nextLevelWords = new HashSet<>();

            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(endWord)) {
                    found = true;
                    continue; // Process all paths on this level before stopping
                }

                char[] chars = currentWord.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String newWord = new String(chars);

                        // If the new word is in the dictionary and hasn't been visited on this level
                        if (dict.contains(newWord) && !visitedOnLevel.contains(newWord)) {
                            if (!parentMap.containsKey(newWord)) {
                                parentMap.put(newWord, new ArrayList<>());
                                queue.add(newWord);
                                nextLevelWords.add(newWord);
                            }
                            // Add currentWord as a parent of newWord
                            parentMap.get(newWord).add(currentWord);
                        }
                    }
                    chars[j] = originalChar; // Backtrack
                }
            }

            if (found) {
                break;
            }

            // Move to the next level. Remove visited words from the dictionary set to prevent cycles
            dict.removeAll(visitedOnLevel);
            visitedOnLevel = nextLevelWords;
        }

        // Phase 2: DFS to reconstruct all paths
        List<String> currentPath = new ArrayList<>();
        currentPath.add(endWord);
        reconstructPaths(endWord, beginWord, parentMap, result, currentPath);

        return result;
    }

    private static void reconstructPaths(String current, String beginWord, Map<String, List<String>> parentMap, List<List<String>> result, List<String> currentPath) {
        if (current.equals(beginWord)) {
            List<String> finalPath = new ArrayList<>(currentPath);
            Collections.reverse(finalPath);
            result.add(finalPath);
            return;
        }

        List<String> parents = parentMap.get(current);
        if (parents != null) {
            for (String parent : parents) {
                currentPath.add(parent);
                reconstructPaths(parent, beginWord, parentMap, result, currentPath);
                currentPath.remove(currentPath.size() - 1); // Backtrack
            }
        }
    }
}
