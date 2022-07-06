package MathsNumSys;

/**                {0 , 1}   {0-7}    {0-9}    {0 - 9  A-f }
 * NUMBER SYSTEM - binary    octal   decimal   hexdecimal
 *                (BASE)2   (BASE)8  (BASE)10   (BASE)16
 *
 * Oerator  - AND(&)    OR(|)   XOR(^)
 * -----------------------------------
 * 0    0   -  0          0      0           * AND of any number with 1 gives = number itself
 * 0    1   -  0          1      1           * OR of any number with 0 gives  = compilment of 0
 * 1    0   -  0          1      1           * OR of any number with 1 gives  = 1
 * 1    1   -  1          1      0           *  A ^ 1 = A (compliment)
 * ----------------------------------        * A ^ 0 = A
 * Compliment (~)  0 ->1 , 1 -> 0            * A ^ A = 0
 *
 * NUMBER SYSTEM:
 * Binary -  0,1
 * Octal  -  0,1,2,3,4,5,6,7
 * Deci   -  0,1,2,3,4,5,6,7,8,9
 * Hexa   -  0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F
 *
 * CONVERSION :
 1. Decimal to Base B -
 * Keep diving by base B take remainder and write in reverse
 * eg = (17)10 = (10001)2
 * eg = (17)10 = (21)8
 *
 *
 2. Base B to  Decimal-
 * Multiple and add the power of base with digit
 * eg = (10001)2 = 16+0+0+0+1 = (17)10
 * eg = (21)8  = 16+1 = (17)10
 *
 *
 3. Base A to Base B
 * Base A to Decimal then Decimal to Base B
 * eg - octal to hexa , hexa to octal, binary to octal, binay to hexa, octal to binary, hexa to binar etc.
 *
 *
 * LEFT SHIFT OPERATOR(<<)
 * eg - (10)10 = (1010)2   now 10 << 1
 *                1 0 1 0 << 1
 *              1 0 1 0 0  = (20)2
 *
 *  A << 1 = 2A
 *  A << B = A*2power(B)
 *
 * LEFT SHIFT OPERATOR(>>)
 * eg - (25)10 = (11001)2   now  25 >> 1
 *               1 1 0 0 1 >> 1
 *               0 1 1 0 0  = (12)2
 * A >> B = A/2power(B)
 *
 *
 * **/


public class BasicMath {
}
