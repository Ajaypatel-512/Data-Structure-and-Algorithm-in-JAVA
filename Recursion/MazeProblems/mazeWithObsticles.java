package Recursion.MazeProblems;

import java.util.ArrayList;

//    when obsticle is in (2,2) on diagonal

public class mazeWithObsticles {
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        permutRet("",board, 0, 0);
    }

    public static void permutRet(String p,boolean[][] maze, int r, int c) {
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length-1){
            permutRet(p+'D',maze,r+1,c);
        }
        if(c < maze[0].length-1){
            permutRet(p+'R',maze,r,c+1);
        }
    }
}
