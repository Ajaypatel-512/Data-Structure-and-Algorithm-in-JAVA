package MathsNumSys.Modulo;
/**
 * GCD / HCF
 * GCD(a,b) = GCD((b % a), a)
 *
 *
 *
 * **/
public class Euclids_AlgoForGCD {
    public static void main(String[] args) {
        int a = 105, b = 224;

        System.out.println(gcd(a,b));

    }

    private static int gcd(int a, int b) {
        if (a==0)
            return b;
        return gcd(b%a,a);
    }
}
