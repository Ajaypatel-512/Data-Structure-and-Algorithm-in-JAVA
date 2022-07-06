package MathsNumSys;

public class SqrtOfDecimalNum {
    public static void main(String[] args) {
        int N = 40;
        int P = 3;

        System.out.printf("%.3f",sqrt(N,P));
    }

    private static double sqrt(int n, int p) {
        int start = 0;
        int end = n;
        double ans = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        double inc = 0.1;
        for (int i = 0; i < p; i++) {
            while (ans * ans < n){
                ans += inc;
            }
            ans -= inc;
            inc /= 10;
        }

        return ans;
    }
}
