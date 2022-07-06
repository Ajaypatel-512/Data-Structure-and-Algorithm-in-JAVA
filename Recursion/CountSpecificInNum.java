package Recursion;
/*********** COUNT SPECIFIC DIGIT IN NUMBER***********/
public class CountSpecificInNum {
    /********* NO. OF ZERO'S IN A NUMBER *********/
    private static int zero(int n) {
        int ans = 0;
        while (n>0){
            int rem = n%10;
            if(rem == 0){
                ans++;
            }
            n = n/10;
        }
        return ans;
    }

    /********* NO. OF ZERO'S IN A NUMBER (Recursion) *********/
    private static int zeros(int n) {
        return helper(n,0);
    }

    private static int helper(int n, int c) {
        if (n == 0)
            return c;
        int rem = n%10;
        if (rem == 0)
            return helper(n/10,c+1);
        return helper(n/10,c);
    }
    /********* MAIN METHOD *********/
    public static void main(String[] args) {
        int n = 460690050;
        System.out.println(zero(n));
        System.out.println(zero(n));
    }

}
