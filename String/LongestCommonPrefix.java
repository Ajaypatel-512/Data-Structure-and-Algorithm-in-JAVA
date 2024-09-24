package String;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"apple","app","apps"};
        System.out.println(longestCommonPrefix(arr));
    }
    public static String longestCommonPrefix(String[] arr) {
        int minlen = findMinLength(arr, arr.length);
        String result = "";
        char current;

        for (int i = 0; i < minlen; i++){
            current = arr[0].charAt(i);

            for (int j = 1; j < arr.length; j++) {
                if (arr[j].charAt(i) != current) {
                    return result;
                }
            }
            result += (current);
        }

        return (result);
    }

    static int findMinLength(String arr[], int n) {
        int min = arr[0].length();

        for (int i = 1; i < n; i++) {
            if (arr[i].length() < min){
                min = arr[i].length();
            }
        }
        return (min);
    }
}
