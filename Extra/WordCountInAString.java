package Extra;

import java.util.StringTokenizer;

public class WordCountInAString {
    public static void main(String[] args) {
        String str = "Hello, this is a test string.";
        int wordCount = countWords(str);
        System.out.println("Number of words: " + wordCount);
    }

    //Solution 1 - Using String.split() method
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    //Solution 2 - Manual Iteration using a loop
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int countWordsRegex(String str) {
        if (str == null || str.trim().isEmpty()) return 0;

        int count = 0;
        boolean inWord = false;

        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {
                inWord = false;
            } else if (!inWord) {
                count++;
                inWord = true;
            }
        }
        return count;
    }

    //Solution 3 - Using StringTokenizer class
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int countWordsUsingStringTokenizer(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        StringTokenizer tokenizer = new StringTokenizer(str);
        return tokenizer.countTokens();
    }
}
