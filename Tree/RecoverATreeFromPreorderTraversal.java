package Tree;

public class RecoverATreeFromPreorderTraversal {
    /**
     * 1028. Recover a Tree From Preorder Traversal
     * We run a preorder depth-first search (DFS) on the root of a binary tree.
     *
     * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.
     *
     * If a node has only one child, that child is guaranteed to be the left child.
     *
     * Given the output traversal of this traversal, recover the tree and return its root.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: traversal = "1-2--3--4-5--6--7"
     * Output: [1,2,5,3,4,6,7]
     * Example 2:
     *
     *
     * Input: traversal = "1-2--3---4-5--6---7"
     * Output: [1,2,5,3,null,6,null,4,null,7]
     * Example 3:
     *
     *
     * Input: traversal = "1-401--349---90--88"
     * Output: [1,401,null,349,88,90]
     *
     *
     * Constraints:
     *
     * The number of nodes in the original tree is in the range [1, 1000].
     * 1 <= Node.val <= 109
     * */
    public static void main(String[] args) {

    }

    //Solution 1 - Using DFS
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    static int index = 0;
    static int n = 0;
    public static TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        return recur(traversal,0);
    }

    private static TreeNode recur(String traversal, int depth) {
        if (index>=n) return null;

        int count = 0;
        int temp = index;

        while (temp < n && !Character.isDigit(traversal.charAt(temp))){
            count++;
            temp++;
        }

        if (count != depth) return null;
        index = temp;

        int val =0;
        while (index < n && Character.isDigit(traversal.charAt(index))){
           val = val*10 + (traversal.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(val);
        node.left = recur(traversal,depth+1);
        node.right = recur(traversal,depth+1);
        return node;
    }


}
