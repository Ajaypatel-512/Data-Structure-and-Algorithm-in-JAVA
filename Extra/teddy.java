//package Extra;
//
//import java.util.Scanner;
//
//public class teddy {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
////        int M = sc.nextInt();
//
//        int[] B = new int[N];
//        int[] C = new int[M];
//
//        for (int i=0; i<N; i++){
//            B[i] = sc.nextInt();
//        }
//        for (int j=0;j<M;j++){
//            C[j] = sc.nextInt();
//        }
//
//        int[] r = B[0]-C[0];
//        int s = C[0];
//        int s1 = C[0]-C[1];
//        int k=0;
//        if(M>0){
//            if(s1>0){
//                System.out.println(2);
//            }else{
//                System.out.println(Math.max(s));
//            }
//        }else if(M<=0){
//            for(int i=1;i<N;i++){
//                int a = B[i]-C[i];
//                r[i] = a;
//            }
//            System.out.println(Math.max(r));
//        }
//
//
//    }
//}
