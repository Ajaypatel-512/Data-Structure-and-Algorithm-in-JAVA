package Arrayss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeNumbersInRange {
    /**
     * 2523. Closest Prime Numbers in Range
     * Given two positive integers left and right, find the two integers num1 and num2 such that:
     *
     * left <= num1 < num2 <= right .
     * Both num1 and num2 are prime numbers.
     * num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
     * Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
     *
     *
     *
     * Example 1:
     *
     * Input: left = 10, right = 19
     * Output: [11,13]
     * Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
     * The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
     * Since 11 is smaller than 17, we return the first pair.
     * Example 2:
     *
     * Input: left = 4, right = 6
     * Output: [-1,-1]
     * Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
     *
     *
     * Constraints:
     *
     * 1 <= left <= right <= 106
     * */
    public static void main(String[] args) {
        int left = 19;
        int right = 31;
        int[] result = closestPrimes(left, right);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 - Sieve of Eratosthenes
    //Time Complexity - O(Rlog(log(R)) + (R-L)) where R is right and L is left
    //Space Complexity - O(R)
    public static int[] closestPrimes(int left, int right) {
        boolean[] isPrime = sieveHelper(right);
        List<Integer> primeArr = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                primeArr.add(num);
            }
        }

        int min = Integer.MAX_VALUE;
        int[] result = new int[]{-1,-1};

        for (int i=1; i<primeArr.size(); i++){
            int sub = primeArr.get(i) - primeArr.get(i-1);
            if (sub < min) {
                min = sub;
                result[0] = primeArr.get(i - 1);
                result[1] = primeArr.get(i);
            }
        }

        return result;
    }

    private static boolean[] sieveHelper(int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j <= right; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }


    //Solution 2 - Early return
    //Time Complexity - O((R-L) * sqrt(R)) where R is right and L is left
    //Space Complexity - O(1)
    public static int[] closestPrimes2(int left, int right) {
        List<Integer> primes = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isPrime(num)) {
                if (!primes.isEmpty() && num - primes.get(primes.size() - 1) <= 2) {
                    return new int[]{primes.get(primes.size() - 1), num}; // Early return
                }
                primes.add(num);
            }
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        return result;
    }

    private static boolean isPrime(int num) {
        if (num == 1) { // not a prime
            return false;
        }
        for (int div = 2; div * div <= num; div++) {
            if (num % div == 0) {
                return false;
            }
        }
        return true;
    }
}
