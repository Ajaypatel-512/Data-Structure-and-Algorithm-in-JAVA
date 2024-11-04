package String;

public class StringCompressionIII {
    public static void main(String[] args) {
        System.out.println(compressedString("aaaabb"));
    }

    //Solution 1 O(n) O(n)
    public static String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();

        int i=0;
        while(i<n) {
            int count = 0;
            char ch = word.charAt(i);

            while (i < n && count < 9 && word.charAt(i) == ch) {
                count++;
                i++;
            }
            sb.append(count+""+ch);
        }
        return sb.toString();
    }

}
