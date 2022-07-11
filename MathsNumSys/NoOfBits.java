package MathsNumSys;
/**
 * no of set bits
 * **/

public class NoOfBits {
    public static void main(String[] args) {
        int n = 200;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(setbits(n));
        System.out.println(hammingWeight(n));
    }
    /*************** METHOD 2 EASIEST METHOD *************/
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /*************** METHOD 1 loop METHOD *************/
    private static int setbits(int n) {
        int count = 0;
//        while (n>0){
//            count++;
//            n -= n& (-n);
//        }
        while (n>0){
//            count++;
            n = n&(n-1);
            count++;
        }
        return count;
    }

}
