package Recursion;

/**
 * Mandetory - Function, memory management
 * It helps us to solve bigger and complex problems in a simple way.
 * you can convert any recusrion solution into iteration and vice cersa.
 * SPACE COMPLEXITY - O(N) not constant becuase of recursive calls.
 * TIME COMPLEXITY - O()


 1. Identify the bigger problem into smaller problems
 2. write the recuurence relation
 3. draw the recursive tree.
 4. about the tree:
      i. see the flow of fuction how they are getting in stack.
     ii. identify and focus on the left tree calls and right tree calls
    iii. draw the tree ans pointers again and again using pen and papers
     iv. use a debugger to see the flow
      v. see how the values are returned at each steps. see where the function call come out of.


 types of recursion
 1. linear recurrence relation  -- fibaonacci
 2. divide and conqure  ---- bianary search

 * **/

public class RecursionFirst {
    public static void main(String[] args) {
        message();
    }
    static void message(){
        System.out.println("Hello world");
        message1();
    }
    static void message1(){
        System.out.println("Hello world");
        message2();
    }
    static void message2(){
        System.out.println("Hello world");
        message3();
    }
    static void message3(){
        System.out.println("Hello world");
        message4();
    }
    static void message4(){
        System.out.println("Hello world");
    }

}
