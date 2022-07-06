package Recursion.Pattern;

public class patter2 {
    public static void main(String[] args) {
        int r = 5;
        print(r,0);
    }

    private static void print(int r,int c) {
        if(r == 0){
            return;
        }
        if(c < r){
            print(r,c+1);
            System.out.print("* ");
        } else{
            print(r-1,0);
            System.out.println();
        }
    }
}
