package Extra;

public class nDigitLargestPrime {
    public static void main(String[] args) {
//        for(int i=100000; i<999999; i++){
//            int flag = 0;
//            for(int j=1; j<i/2; j++){
//                if(i%j == 0){
//                    flag++;
//                }
//                if(flag == 1){
//                    System.out.println(i);
//                    break;
//                }
//            }
//        }
        int n = 999999;
        for(int i=999999; i>999999/2; i--){
            if(isPrime(i)){
                System.out.print(i+" ");
                break;
            }
        }
    }

    private static boolean isPrime(int j) {
        boolean flag = false;
        if(j<2)
            return flag;

        for(int i=2; i<j; i++){
            if(j%i == 0){
               return false;
            }
        }
        return true;
    }
}
