package MathsNumSys;
/**
 * FIND ith bit of a number
 *
 * index = 8 7 6 5 4 3 2 1
 * eg    = 1 0 1 1 0 1 1 0  find value at index 5
 * o/p   = 1
 *
 *         8 7 6 5 4 3 2 1
 * logic - 1 0 1 1 0 1 1 0
 *      &  0 0 0 1 0 0 0 0   -------> this is called mask
 *         ----------------
 *         0 0 0 1 0 0 0 0
 *         ---------------
 *
 * for n we need to create a mask of n-1 zeros
 * 1 << 4  ---> 1 0 0 0 0
 *
 * ans = num & (1 << (index - 1))
 *
 * **/
public class iBitNum {
    public static void main(String[] args) {
        int num = 20;   // 10100
        int index = 3;
        System.out.println(findBit(num,index));
    }

    private static int findBit(int num, int index) {
        int bit = 0;


        return bit;
    }
}
