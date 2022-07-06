package MathsNumSys;

public class SqrtNum {
    public static void main(String[] args) {
        int N = 140;
//        System.out.println(Math.sqrt(N));   METHOD 1

        int start = 0;
         int end = N;
        int mid = 0;
        while (start <= end){
              mid = start + (end - start)/2;
            if (mid * mid == N) {
                System.out.println(mid);
                return;
            }
            else if(mid * mid < N) {
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        System.out.println(mid);
    }
}
