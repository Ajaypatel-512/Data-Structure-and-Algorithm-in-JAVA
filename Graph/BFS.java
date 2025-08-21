package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    //write steps for BFS algorithm
    //1. Create a queue to hold the nodes to be visited.
    //2. Create a boolean array to keep track of visited nodes.
    //3. Enqueue the starting node and mark it as visited.
    //4. While the queue is not empty:
    //   a. Dequeue a node from the queue.
    //   b. Process the node (e.g., print its value).
    //   c. For each unvisited neighbor of the node:
    //      i. Mark the neighbor as visited.
    //      ii. Enqueue the neighbor.
    //5. Repeat step 4 until the queue is empty.
    //6. The algorithm ends when all reachable nodes from the starting node have been visited.

    //write code for BFS algorithm
    //Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
    //Space Complexity: O(V) for the visited array and the queue.
    public List<Integer> bfs(int v, List<List<Integer>> adjList) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.add(node);
            for (Integer neighbor : adjList.get(node)) {
                if (visited[neighbor] == false) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }

            }
        }
       return bfs;
    }
}
