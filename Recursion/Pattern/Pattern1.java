package Recursion.Pattern;

public class Pattern1 {
    public static void main(String[] args) {
        int r = 5;
        print(r,0);
    }

    private static void print(int r,int c) {
        if(r == 0){
            return;
        }
        if(c < r){
            System.out.print("* ");
            print(r,c+1);
        } else{
            System.out.println();
            print(r-1,0);
        }
    }
}
