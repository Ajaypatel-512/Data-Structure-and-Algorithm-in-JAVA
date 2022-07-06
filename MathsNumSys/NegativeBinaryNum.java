package MathsNumSys;
/**
 * 1 byte = 8 bits
 *            MSB             LSB
 * eg = 10  -> 0  0 0 0 1 0 1  0  (8 bits/1 byte)
 *
 * MSB == 1 number = negative
 * MSB == 0 number = positive

 TO FIND NEGATIVE OF A NUMBER ----> SUBTRACTED THAT NUMBER FROM 10000(LIKE THESE NUMBER)
 eg =  we want neagtive of 10 in binary then

           1 0 0 0 0 0 0 0 0                          8      =     7    +   1
        -    0 0 0 0 1 0 1 0                       1 0 0 0   =   1 1 1  +   1
----------------------------------

 now what is 1 0 0 0 0 0 0 0 0
             1 0 0 0 0 0 0 0 0   =====> 1 1 1 1 1 1 1 1 + 1

so we can write it as
            1 1 1 1 1 1 1 1 + 1 - 0 0 0 0 1 0 1 0
            1 1 1 1 1 1 1 1 - 0 0 0 0 1 0 1 0 + 1
         +-----------------------------------+
            1 1 1 1 1 1 1 1
         -  0 0 0 0 1 0 1 0
          ------------------
            1 1 1 1 0 1 0 1          ====> 1's compliment
          ------------------

 ---------+-------------------+------------------+-----------------------+-----------------------+-----
 ---------+-------------------+------------------+-----------------------+-----------------------+-----

 * STEP 1: Take compliment
 * STEP 2: Add 1 to it                      also known 2's Compliment method
 *
 * eg = (10)10 = (00001010)2
 *  1.   1 1 1 1 0 1 0 1       ======> 1's compliment
 *  2. +               1
 *      .................
 *     ( 1 1 1 1 0 1 1 0 )2  ====> ( -10 )10
 *      .................
 * **/
public class NegativeBinaryNum {

}
