package Extra;
/**
 2139. Minimum Moves to Reach Target Score

 You are playing a game with integers. You start with the integer 1 and you want to reach the integer target.
 In one move, you can either:
 1. Increment the current integer by one (i.e., x = x + 1).
 2. Double the current integer (i.e., x = 2 * x).
 You can use the increment operation any number of times, however, you can only use the double operation at most maxDoubles times.
 Given the two integers target and maxDoubles, return the minimum number of moves needed to reach target starting with 1.

 Example 1:
 Input: target = 5, maxDoubles = 0
 Output: 4
 Explanation: Keep incrementing by 1 until you reach target.
 Example 2:

 Input: target = 19, maxDoubles = 2
 Output: 7
 Explanation: Initially, x = 1
 Increment 3 times so x = 4
 Double once so x = 8
 Increment once so x = 9
 Double again so x = 18
 Increment once so x = 19
 Example 3:

 Input: target = 10, maxDoubles = 4
 Output: 4
 Explanation: Initially, x = 1
 Increment once so x = 2
 Double once so x = 4
 Increment once so x = 5
 Double again so x = 10
 **/
public class MinMovesToTarget {
    public static void main(String[] args) {
        int target = 10;
        int maxDoubles = 4   ;
        System.out.println(minMoves(target,maxDoubles));
    }

    static int minMoves(int target, int maxDoubles) {
//        int temp = target;
//        int count = 0;
//        while (temp != 1){
//            if(temp%2 == 0 && maxDouble != 0){
//                temp =temp / 2;
//                maxDouble = maxDouble-1;
//                count++;
//            } else {
//                temp = temp - 1;
//                count++;
//            }
//        }
//        return count;
        if(target == 1){
            return 0;
        }
        if(maxDoubles == 0){
            return target - 1;
        }
        if(target % 2 == 0){
            target = target/2;
            maxDoubles = maxDoubles-1;
            return minMoves(target, maxDoubles) + 1;
        }else{
            target = target - 1;
            target /= 2;
            maxDoubles = maxDoubles - 1;
            return minMoves((target - 1) / 2, maxDoubles - 1) + 2;
        }
    }
}
