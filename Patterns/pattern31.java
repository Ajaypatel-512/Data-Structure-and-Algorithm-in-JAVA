package Patterns;

public class pattern31 {
    public static void main(String[] args) {
        int []x[] = {{2,3},{1,2}};
        int [][]y = x;
        int c = 1;
        System.out.println(y[1][1]);
    }
//    static void pattern1(int n) {
//        for (int i = 0; i < 2*n-1; i++) {
//            for (int j = 0; j < 2*n-1; j++) {
//                int index = 345;
//                if(i == 0 || j == 0 || i == 2*n-2 || j == 2*n-2){
//                    index = n;
//                }else{
//                    index = n-1;
//                }
//                System.out.print(index+" ");
//            }
//            System.out.println();
//        }


//        int orginalN = n;
//        n = 2*n-1;
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= n ; j++) {
//                int index = orginalN - Math.min(Math.min(i,j),Math.min(n-i,n-j));
//                System.out.print(index+" ");
//            }
//            System.out.println();
//        }
//    }
}
