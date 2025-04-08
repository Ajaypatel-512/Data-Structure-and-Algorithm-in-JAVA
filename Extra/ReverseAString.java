package Extra;

import java.util.stream.Collectors;

public class ReverseAString {
    public static void main(String[] args) {
        String str = "Hello, World!";
        String reversedStr = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversedStr);
    }

    // Method to reverse a string using different approaches

    // 1. Using StringBuilder
    //Time complexity: O(n)
    //Space complexity: O(n)
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // 2. Using recursion
    //Time complexity: O(n)
    //Space complexity: O(n) for recursion stack
    public static String reverseStringUsingRecursion(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseStringUsingRecursion(str.substring(1)) + str.charAt(0);
    }

    // 3. Using StringBuilder and StringBuffer reverse methods
    //Time complexity: O(n)
    //Space complexity: O(n) for StringBuilder
    public static String reverseStringUsingStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // 4. Using streams reduce method
    //Time complexity: O(n)
    //Space complexity: O(n) for the stream
    public static String reverseStringUsingStream(String str) {
        return str.chars()
                  .mapToObj(c -> (char) c)
                  .reduce("", (s, c) -> c + s, (s1, s2) -> s1 + s2);
    }

    // 5. Using StringBuilder with streams
    //Time complexity: O(n)
    //Space complexity: O(n) for StringBuilder
    public static String reverseStringUsingLoop(String str) {
        String reversed = new StringBuilder(
                String.valueOf(str.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList()))
        ).reverse().toString();

        System.out.println("Reversed: " + reversed);
    }

    //using 2 pointer
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static String reverseStringUsingTwoPointer(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

}
