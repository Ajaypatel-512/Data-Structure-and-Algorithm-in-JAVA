package MathsNumSys;

public class findUnique {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,3,7,2,8,1,5,8};
        System.out.println(ans(arr));
    }

    public static int ans(int[] arr) {
        int unique = 0;
        for (int n: arr) {
            unique ^= n;
        }
        return unique;
    }
}
