package Recursion.MazeProblems;

/**
 * https://www.youtube.com/watch?v=zg5v2rlV1tM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=35&t=4s
 * 19:00 min
 *
 *
 * */

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
    }
    public static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = count(r-1,c);
        int right = count(r,c-1);
        return left+right;
    }
}
