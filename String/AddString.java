package String;

public class AddString {
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";

        System.out.println(addStrings(num1,num2));
    }

    /**
     * This Works for small values
     * */
    private static String addStringSmallValues(String num1, String num2) {
        Integer x = Integer.valueOf(num1);
        Integer y = Integer.valueOf(num2);

        return String.valueOf(x+y);
    }

    /**
     * This Works for all values
     * */
    public static String addStrings(String num1, String num2) {
        String res = "";

        int i = num1.length()-1;
        int j = num2.length()-1;

        int carry = 0;

        while(i>=0 || j>=0 || carry !=0){
            int iVal = i >= 0 ? (num1.charAt(i)-'0') : 0;
            int jVal = j >= 0 ? (num2.charAt(j)-'0') : 0;
            i--;
            j--;

            int sum = iVal + jVal + carry;
            int val = sum %10;
            res = val + res;
            carry = sum / 10;
        }
        return res;
    }
}
