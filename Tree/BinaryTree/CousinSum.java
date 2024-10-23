package Tree.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinSum {
    /**
     * 2641. Cousins in Binary Tree II
     *
     * Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
     *
     * Two nodes of a binary tree are cousins if they have the same depth with different parents.
     *
     * Return the root of the modified tree.
     *
     * Note that the depth of a node is the number of edges in the path from the root node to it.
     *
     * Example 1:
     *
     *
     * Input: root = [5,4,9,1,10,null,7]
     * Output: [0,0,0,7,7,null,11]
     * Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
     * - Node with value 5 does not have any cousins so its sum is 0.
     * - Node with value 4 does not have any cousins so its sum is 0.
     * - Node with value 9 does not have any cousins so its sum is 0.
     * - Node with value 1 has a cousin with value 7 so its sum is 7.
     * - Node with value 10 has a cousin with value 7 so its sum is 7.
     * - Node with value 7 has cousins with values 1 and 10 so its sum is 11.
     * Example 2:
     *
     *
     * Input: root = [3,1,2]
     * Output: [0,0,0]
     * Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
     * - Node with value 3 does not have any cousins so its sum is 0.
     * - Node with value 1 does not have any cousins so its sum is 0.
     * - Node with value 2 does not have any cousins so its sum is 0.
     * */
    public static void main(String[] args) {
        System.out.println(replaceValueInTree(new TreeNode()));
    }

    //Solution 1
    public static TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.add(root);

        int sum = root.val;
        while (!queue.isEmpty()){
            int size = queue.size();
            int currentLevelSum = 0;

            while (size-- != 0){
                TreeNode currentNode = queue.poll();
                int remaining = sum-currentNode.val;

                if (map.containsKey(currentNode)){
                    remaining -= map.get(currentNode);
                }
                currentNode.val = remaining;

                if (currentNode.left != null){
                    queue.add(currentNode.left);
                    currentLevelSum += currentNode.left.val;

                    if (currentNode.right != null){
                        map.put(currentNode.left,currentNode.right.val);
                    }
                }

                if (currentNode.right != null){
                    queue.add(currentNode.right);
                    currentLevelSum += currentNode.right.val;

                    if (currentNode.left != null){
                        map.put(currentNode.right,currentNode.left.val);
                    }
                }
            }
            sum = currentLevelSum;
        }
        return root;
    }
}
