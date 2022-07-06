package Patterns;

public class pattern30 {
    public static void main(String[] args) {
        pattern1(5);
        System.out.println();
        pattern17(5);
        System.out.println();
    }

    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j >0 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void pattern17(int n) {
        for (int i = 1; i <= 2*n-1; i++) {

            int col = i >n ? 2*n - i: i;

            for (int j = 0; j < n - col; j++) {
                System.out.print("  ");
            }
            for (int j = col; j >0 ; j--) {
                System.out.print(j+" ");
            }
            for (int j = 2; j <= col; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
