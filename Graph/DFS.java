package Graph;

import java.util.List;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {

    }

    //write steps for DFS algorithm using recursion
    //1. Create a boolean array to keep track of visited nodes.
    //2. Start from the given node and mark it as visited.
    //3. Process the node (e.g., print its value).
    //4. For each unvisited neighbor of the node:
    //   a. Recursively call the DFS function for the neighbor.
    //5. Repeat steps 3-4 until all reachable nodes from the starting node have been visited.
    //6. The algorithm ends when all reachable nodes from the starting node have been visited.



    //write code for DFS algorithm using recursion
    //Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
    //Space Complexity: O(V) for the visited array and the recursion stack.
    public void dfs(int v, boolean[] visited, List<List<Integer>> adjMatrix, List<Integer> result) {
        visited[v] = true;
        result.add(v);

        for (Integer neighbor : adjMatrix.get(v)) {
            if (visited[neighbor] == false) {
                dfs(neighbor, visited, adjMatrix, result);
            }
        }
    }

    //write steps for DFS algorithm using stack
    //1. Create a stack to hold the nodes to be visited.
    //2. Create a boolean array to keep track of visited nodes.
    //3. Push the starting node onto the stack and mark it as visited.
    //4. While the stack is not empty:
    //   a. Pop a node from the stack.
    //   b. Process the node (e.g., print its value).
    //   c. For each unvisited neighbor of the node:
    //      i. Mark the neighbor as visited.
    //      ii. Push the neighbor onto the stack.
    //5. Repeat step 4 until the stack is empty.
    //6. The algorithm ends when all reachable nodes from the starting node have been visited.

    //write code for DFS algorithm using stack
    //Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
    //Space Complexity: O(V) for the visited array and the stack.
    public void dfsStack(int v, boolean[] visited, List<List<Integer>> adjMatrix, List<Integer> result) {
       Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            result.add(node);

            for (Integer neighbor : adjMatrix.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}
