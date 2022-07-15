package Backtracking;
/************************** BACKTRACING ***************************/

/**
 * STACK OVERFLOW
 * recusrion never ends
 * when u go down then up will also called which take you to up.
 * hence back to top
 *
 **************************************** HOW TO SOLVE **************************
 * dont allow to visit the visited cells
 * mark visited cells as false
 * so that that visited cells cannot be revisited.
 * already visited cells will not call function again.
 *
 * PROBLEM:
 * making cells false mealse i have that cells in my current path.\
 * so when that path is over,   eg another path, another recusrion call
 * those cells should not be false
 *
 *
 * Solution:  BACKTRACKING
 * while you are moving back, you should restore the maze as it was.
 *
 *
 * **/
public class mazeAllDirection {
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        AllPath("",board, 0, 0);
    }
    public static void AllPath(String p,boolean[][] maze, int r, int c) {
        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        maze[r][c] = false;    //considering this block as in my path

        if(r < maze.length-1){
            AllPath(p+'D',maze,r+1,c);
        }
        if(c < maze[0].length-1){
            AllPath(p+'R',maze,r,c+1);
        }
        if(r > 0){
            AllPath(p+'U',maze,r-1,c);
        }
        if(c > 0){
            AllPath(p+'L',maze,r,c-1);
        }

        //considering this line is where the fucntion will over
        // before the function will remove also removed the changes.
        maze[r][c] = true;
    }
}
