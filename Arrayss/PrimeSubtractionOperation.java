package Arrayss;

public class PrimeSubtractionOperation {
    static boolean[] isPrime = new boolean[1000];
    public static void main(String[] args) {
        int[] num = {4,9,6,10};
        System.out.println(primeSubOperation(num));
    }

    //O(1)
    static void sieve(){
        for (int i=0; i<1000; i++){
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i=2; i*i < 1000; i++){
            if (isPrime[i]){
                for (int j=i*i; j<1000; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }

    //Solution 1 O(n*maxNum) O(1)
    public static boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        sieve();

        for (int i=n-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                continue;
            }

            for (int p=2; p<nums[i]; p++){
                if (!isPrime[p]){
                    continue;
                }

                if (nums[i] - p < nums[i+1]){
                    nums[i] -= p;
                    break;
                }
            }
            if (nums[i] >= nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
