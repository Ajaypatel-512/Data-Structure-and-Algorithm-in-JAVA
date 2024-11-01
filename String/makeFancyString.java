package String;

public class makeFancyString {
    public static void main(String[] args) {
//        System.out.println(makeFancyString1("1aavb"));
        System.out.println(makeFancyString2("1aavb"));
    }

    // Solution 1 Using Brute Force Approach O(n) O(n)
    public static String makeFancyString1(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                count++;
            }
            if (s.charAt(i) != s.charAt(i+1)){
                count = 1;
            }
            if (count < 3){
                sb.append(s.charAt(i));
            }
        }
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }

    // Solution 1 Using Brute Force Approach O(n) O(n)
    public static String makeFancyString2(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        sb.append(s.charAt(0));
        int freq = 1;

        for (int i=1; i<n; i++){
            if (s.charAt(i) == sb.charAt(sb.length()-1)){
                freq++;
                if (freq < 3){
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
                freq = 1;
            }
        }
        return sb.toString();
    }



}
