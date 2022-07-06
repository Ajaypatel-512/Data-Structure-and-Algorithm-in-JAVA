package MathsNumSys;
/***
 * TIME COMPLEXITY
 *      O( ( log N) f(N) )
 *      f(n) = cost of calculating f(x)/f'(x) with some digit of precision
 *
 *
 * */
public class NewtonRephsonSqrtMethod {
    public static void main(String[] args) {
        int N = 40;
        System.out.println(sqrt(N));
    }
    static double sqrt(double n){
        double x = n;
        double root;
        while (true){
            root = 0.5 * (x + (n/x));
            if (Math.abs(root- x) < 0.5){
                break;
            }
            x = root;
        }
        return root;
    }
}
