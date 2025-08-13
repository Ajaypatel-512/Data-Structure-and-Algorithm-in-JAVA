package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {
    /**
     * 297. Serialize and Deserialize Binary Tree
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,3,null,null,4,5]
     * Output: [1,2,3,null,null,4,5]
     * Example 2:
     *
     * Input: root = []
     * Output: []
     *
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 104].
     * -1000 <= Node.val <= 1000
     * */
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserialize serializer = new SerializeAndDeserialize();
        String serialized = serializer.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = serializer.deserialize(serialized);
        System.out.println("Deserialized: " + serializer.serialize(deserializedRoot));
    }


    //Solution 1: Using BFS (Level Order Traversal)
    //Time Complexity: O(n), where n is the number of nodes in the tree.
    //Space Complexity: O(n), for the queue used in BFS and the string builder.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    //Solution 1: Using BFS (Level Order Traversal)
    //Time Complexity: O(n), where n is the number of nodes in the tree.
    //Space Complexity: O(n), for the queue used in BFS.
    public static TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
//        int index = 1;

        for (int i=0; i<nodes.length; i++) {
            TreeNode node = queue.poll();
            if (!nodes[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            }

            if (i < nodes.length && !nodes[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            }
        }
        return root;
    }


    //Solution 2: Using Preorder Traversal (Recursive)
    //Time Complexity: O(n), where n is the number of nodes in the tree.
    //Space Complexity: O(n), for the string builder used in serialization and the recursion stack in deserialization.
    public static String serialize2(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    //Solution 2: Using Preorder Traversal (Recursive)
    //Time Complexity: O(n), where n is the number of nodes in the tree.
    //Space Complexity: O(n), for the recursion stack used in deserialization.
    public static TreeNode deserialize2(String data) {
        String[] nodes = data.split(",");
        int[] index = {0}; // Use an array to keep track of the current index
        return deserializeHelper(nodes, index);
    }

    private static TreeNode deserializeHelper(String[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        node.left = deserializeHelper(nodes, index);
        node.right = deserializeHelper(nodes, index);
        return node;
    }
}
