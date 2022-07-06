package MathsNumSys;

/**
 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000

 Input: s = "III"                 Input: s = "LVIII"                         Input: s = "MCMXCIV"
 Output: 3                        Output: 3                                  Output: 1994
 Explanation: III = 3.            Explanation: L = 50, V= 5, III = 3.        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 **/
public class RomanToInt {
    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        if(s.length() == 1){

        }
        return 1;
    }
}
