package MathsNumSys;

/**

 count prime By Sieve Of Eratosthenes

 * **/

public class kPrimeNum {
    public static void main(String[] args) {
        int N = 40;
        boolean[] primes = new boolean[N+1];
        System.out.println(findPrime(N,primes)+1);
    }

    static int findPrime(int n,boolean[] primes) {
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!primes[i]){
                for (int j = 2*i; j<=n; j+=i){
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= n ; i++) {
            if (!primes[i]){
                count = count+1;
            }
        }
        return count;
    }
}