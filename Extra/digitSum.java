package Extra;

public class digitSum {
    public static void main(String[] args) {
        int N = 55;
        int sum = 0;
        while(N>0 || sum >9){
            if(N==0){
                N = sum;
                sum=0;
            }
            sum += N%10;
            N = N/10;
        }
        System.out.println(sum);
    }
}
