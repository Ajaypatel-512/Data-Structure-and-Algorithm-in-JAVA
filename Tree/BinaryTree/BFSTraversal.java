package Tree.BinaryTree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("BFS Traversal:");
        List<List<Integer>> list = bfsTraversal(root);

        for (List<Integer> subList : list) {
            System.out.println(subList);
        }

    }

    //Time Complexity: O(n) where n is the number of nodes in the tree.
    //Space Complexity: O(n) for the queue used in BFS.
    private static List<List<Integer>> bfsTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null) return result;
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelSize; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            result.add(subList);
        }
        return result;
    }


}
