package MathsNumSys;
/**
 *      5^3     5^2     5^1
 *  1   0       0       1     ---> 5
 *  2   0       1       0     ---> 25
 *  3   0       1       1     ---> 30
 *  ...
 *
 *  if n == 6
 *
 *  6   1       1       0   --->  150

 logic:
 n = 6    1 1 0
 last digit in binary = n & 1
 right shift  n >> 1
 **/
public class MagicNumber {
    public static void main(String[] args) {
        int n = 18;

        int ans = 0;
        int base = 5;
        int count = 1;
        while (n>0){
            int last = n&1;
            n = n>>1;
            count += 1;
            ans += last*base;

            base = base*5;
        }
        System.out.println("Count = "+count+" "+"  ans = "+ans);
    }
}
