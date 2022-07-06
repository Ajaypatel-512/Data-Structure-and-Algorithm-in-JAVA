package MathsNumSys;
/**
 * Change / set the ith bit  (0 --> 1)
 * index = 7 6 5  4 3 2 1
 * eg    = 1 0 1 (0) 1 1 0   // set 4th bit to 1
 *         0 0 0 (1) 0 0 0
 *         -------------
 *     OR  1 0 1 (1) 1 1 0  ----> create mask
 *         -------------


 * Change / reset the ith bit  (1 --> 0 )
 * index = 7 6  5 4 3 2 1
 * eg    = 1 0 (1) 0 1 1 0   // reset 5th
 *     &   1 1 (0) 1 1 1 1
 *         -------------
 *         1 0 (0) 0 1 1 0   ----> create mask
 *         -------------
 *

    FINDING MASK - ! ( 1 << (n - 1))

 * **/
public class setithBit {
    public static void main(String[] args) {

    }
}
