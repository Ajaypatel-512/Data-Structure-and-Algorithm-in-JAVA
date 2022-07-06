package Patterns;
/**
         *
       * *
     * * *
   * * * *
 * * * * *
 *
 * **/
public class Patter67 {
    public static void main(String[] args) {
        pattern1(5);
        System.out.println();
    }

    static void pattern1(int n) {
        for (int i = 1; i < n; i++) {
            int totalColInRow = 5;
            for (int j = 1; j < totalColInRow; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
