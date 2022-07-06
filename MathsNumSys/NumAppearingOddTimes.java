package MathsNumSys;
/**
 * find single no which is not appearing 3 times
 * arr[] = 2 2 3 2 7 7 8 7 8 8
 * o/p = 3
 *
 * representation in 8 bites is
 *  2       0 0 0 0 0 0 1 0
 *  2       0 0 0 0 0 0 1 0
 *  3       0 0 0 0 0 0 1 1
 *  2       0 0 0 0 0 0 1 0
 *  7       0 0 0 0 0 1 1 1
 *  7       0 0 0 0 0 1 1 1
 *  8       0 0 0 0 1 0 0 0
 *  7       0 0 0 0 0 1 1 1
 *  8       0 0 0 0 1 0 0 0
 *  8       0 0 0 0 1 0 0 0
 *---------------------------
                    3 3 7 4      take % with 3 == 0 0 1 1 ==> 3 ans
 *---------------------------
   as 3 is appearing 1 time only
   remove 3-> 0 0 0 0 0 0 1 1
 *---------------------------
                    3 3 6 3       ====> every set bit is multiple of 3 hence ans 3
 *---------------------------
 *
 *
 * **/
public class NumAppearingOddTimes {
    public static void main(String[] args) {
        int[] arr = {2,2,3,2,7,7,8,7,8,8};

    }
}
