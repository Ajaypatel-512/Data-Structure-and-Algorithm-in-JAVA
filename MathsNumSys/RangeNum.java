package MathsNumSys;
/**
 * RANGE OF NUMBER
 * 1 byte can store 256 unique numbers
 * 1 byte = 8 bits     ===> 2**8
 *
 * but MSB BIT is a sign bit then
 * In 1 byte actual number store is 2**7 ==> 128


  RANGE [-128, 127]
  total = 256      [128+127 = 255 + 0th number = 256]

 * why -128(negative 128 only) / 127(positive 127 only) ?
 * Beacuse  0  is positive [0 - 127 = 128]


==================== Range Formula ==============================
                -2pow(n-1) to 2pow(n-1)-1
=================================================================
 * **/

public class RangeNum {
}
