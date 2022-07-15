package Backtracking;
/*****************************/

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=zg5v2rlV1tM&list=PL9gnSGHSqcnr_DxHsP7AW9ftq0AtAyYqJ&index=35&t=4s
 * last question 6 1:15 min
 *
 *
 *
 *
 * ***************************/

public class PrintAllPathMatrix {
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[board.length][board[0].length];
        AllPathPrint("",board, 0, 0,path,1);
    }
    public static void AllPathPrint(String p,boolean[][] maze, int r, int c,int[][] path, int step) {
        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for (int[] arr:path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;    //considering this block as in my path
        path[r][c] = step;
        if(r < maze.length-1){
            AllPathPrint(p+'D',maze,r+1,c,path,step+1);
        }
        if(c < maze[0].length-1){
            AllPathPrint(p+'R',maze,r,c+1,path,step+1);
        }
        if(r > 0){
            AllPathPrint(p+'U',maze,r-1,c,path,step+1);
        }
        if(c > 0){
            AllPathPrint(p+'L',maze,r,c-1,path,step+1);
        }

        //considering this line is where the fucntion will over
        // before the function will remove also removed the changes.
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
