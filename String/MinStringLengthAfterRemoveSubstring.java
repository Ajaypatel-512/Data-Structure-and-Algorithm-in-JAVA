package String;

import java.util.Stack;

public class MinStringLengthAfterRemoveSubstring {

    /**
     * 2696. Minimum String Length After Removing Substrings
     *
     * You are given a string s consisting only of uppercase English letters.
     *
     * You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.
     *
     * Return the minimum possible length of the resulting string that you can obtain.
     *
     * Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.
     *
     * Example 1:
     *
     * Input: s = "ABFCACDB"
     * Output: 2
     * Explanation: We can do the following operations:
     * - Remove the substring "ABFCACDB", so s = "FCACDB".
     * - Remove the substring "FCACDB", so s = "FCAB".
     * - Remove the substring "FCAB", so s = "FC".
     * So the resulting length of the string is 2.
     * It can be shown that it is the minimum length that we can obtain.
     * Example 2:
     *
     * Input: s = "ACBBD"
     * Output: 5
     * Explanation: We cannot do any operations on the string so the length remains the same.
     * */

    public static void main(String[] args) {
        System.out.println("Using Brute Force : " + minLength1("ABFCACDB"));

        System.out.println("Using Stack : " + minLength2("ABFCACDB"));

        System.out.println("Using Two Pointer : " +minLength3("ABFCACDB"));
    }

    //SOLUTION 1 - Brute Force Approach O(N2)
    public static int minLength1(String s) {
        boolean found = true;

        while (found){
            found = false;

            int abIndex = s.indexOf("AB");
            if (abIndex != -1){
                s = s.substring(0,abIndex) + s.substring(abIndex + 2);
                found = true;
            }

            int cdIndex = s.indexOf("CD");
            if (cdIndex != -1){
                s = s.substring(0,cdIndex) + s.substring(cdIndex + 2);
                found = true;
            }
        }
        return s.length();
    }

    //SOLUTION 2 - Stack Approach O(N) O(N)
    public static int minLength2(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            if (!stack.isEmpty()){
                char top = stack.peek();
                if((top == 'A' && ch == 'B') || (top == 'C' && ch == 'D')){
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        return stack.size();
    }

    //SOLUTION 3 - Two Pinter Approach O(N) O(1)
    public static int minLength3(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();

        int i = 0;
        int j = 1;

        while(j<n){

            if(i<0){
                i++;
                arr[i] = arr[j];
            } else if((arr[i] == 'A' && arr[j] == 'B') || (arr[i] == 'C' && arr[j] == 'D')){
                i--;
            } else{
                i++;
                arr[i] = arr[j];
            }
            j++;
        }
        return i+1;
    }
}
