package MathsNumSys.Modulo;
/**
 * LCM - least common multiple
 *     - least common factor which divided by both
 *
 *  Eg.  we have a, b       d = gcd(a,b)
 *                          f = a/d  and g = b/d
 *                          a = f*d  and b = g*d
 *      let LCM = c
 *                  LCM(a, b) = LCM(fd, gd)

 We note that f and g will have no other common factor
 *
 * eg. a = 9, b = 18  d = gcd(a,b) = 9
 *     f = a/d = 1
 *     g = b/d = 2
 *
 *     a = f*d
 *     b = g*d
 *     lcm = f*g*d

 NOTE: A * B = LCM * HCF
       LCM(a,b) = (a * b) / HCF(a,b)

 * **/
public class Lcm {
    public static void main(String[] args) {
        int a = 2, b = 7;
        System.out.println(lcm(a,b));
    }

    private static int gcd(int a, int b) {
        if (a==0)
            return b;
        return gcd(b%a,a);
    }

    private static int lcm(int a, int b) {
        return a*b / gcd(a,b);
    }
}
