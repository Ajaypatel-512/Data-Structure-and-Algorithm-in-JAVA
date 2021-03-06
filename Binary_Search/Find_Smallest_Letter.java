package Binary_Search;

//744. Find Smallest Letter Greater Than Target
//Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
//
//        Note that the letters wrap around.
//
//        For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
//
//
//        Example 1:
//
//        Input: letters = ["c","f","j"], target = "a"
//        Output: "c"
//        Example 2:
//
//        Input: letters = ["c","f","j"], target = "c"
//        Output: "f"
//        Example 3:
//
//        Input: letters = ["c","f","j"], target = "d"
//        Output: "f"


public class Find_Smallest_Letter {

    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters,target));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;

        while(start<=end){
            int mid = start + (end - start) / 2;
            if(target < letters[mid]) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length] ;
    }
}
