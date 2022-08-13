package Extra.TCS_NQT;

import java.util.Scanner;

public class primeAndComposite {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = {2,3,4,5,6,7,8,33,22,55,77,88,22};
        int primeCount = 0;
        int compCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
               primeCount++;
            }else{
                compCount++;
            }
        }
        System.out.println("prime numbers count : "+primeCount);
        System.out.println("composite numbers count : "+compCount);

    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
