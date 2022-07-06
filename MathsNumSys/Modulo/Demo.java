package MathsNumSys.Modulo;
/***
 *  (a + b) % m = ((a % m) + (b % m)) % m
 *  (a - b) % m = ((a % m) - (b % m) + m) % m
 *  (a * b) % m = ((a % m) * (b % m)) % m
 *  (a / b) % m = ((a % m) * (b-1 % m)) % m   [b-1  = multiplicative inverse]
 *  (a % m) % m = a % m
 *  a^x % m = 0   for all x belong to positive integer
 *
 *
 *  EX: (6 * y) % 7 = 1
 *      y = MMI for 6 and y = 6
 *      (6 * 6) % 7 = 1
 *
 *
 *  NOTE: MMI = b-1 % m means that b and m are co-prime [only 1 common factor]
 *
 *
 *
 * */

public class Demo {
    public static void main(String[] args) {

    }
}
