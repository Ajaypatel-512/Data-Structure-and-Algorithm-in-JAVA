package MathsNumSys;
/**
 * eg -    1  0  0  1  1                        check for even odd
 *        ----------- --
 *        even power  odd power
 *
 * if last bit is 1 then the number is ODD
 * if last bit is 0 then the number is EVEN
 *
 * CHECKING FOR ODD                                     CHECKING FOR EVEN
 * logic - if(Number & 1 == 1)                          if(Number & 1 == 0)
 *              return true                                 return true
 *         else                                         else
 *              return false                                return false
 * **/


public class EvenOdd {
    public static void main(String[] args) {
        int num = 68;
        System.out.println(isOdd(num));
    }

    public static boolean isOdd(int num) {
        return (num&1)==1;
    }
}
