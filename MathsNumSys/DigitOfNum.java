package MathsNumSys;

/**
 logic:
 n = 6  base = 2   (6 in binary is 1 1 0)  ======> 3 digit
 log2(6) = x
 6 = 2^x
ans = x+1;

 n = 100  base = 10   (100 in decimal is 1 0 0)  ======> 3 digit
 log10(100) = 2

ans = 2+1 = 3;
 * **/

public class DigitOfNum {
    public static void main(String[] args) {
        int n = 7;
        int b = 2;

        int ans = (int)(Math.log(n) / Math.log(b)) +1;   // loga(b) = logx(a) / logx(b)
        System.out.println(ans);
    }
}
