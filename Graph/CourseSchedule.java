package Graph;

import java.util.*;

public class CourseSchedule {
    /**
     * 207. Course Schedule
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * Hint
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     *
     *
     * Constraints:
     *
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * All the pairs prerequisites[i] are unique.
     * */
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    //Solution 1: Topological Sort using Kahn's Algorithm (BFS)
    //Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisites.
    //Space Complexity: O(V + E) for the adjacency list and in-degree array.
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course); // prereq -> course
            inDegree[course]++;         // count incoming edges
        }

        // Queue for courses with 0 in-degree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // count of courses we can take

        while (!q.isEmpty()) {
            int course = q.poll();
            count++;

            for (int neighbor : adj.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // If count equals numCourses, no cycle exists
        return count == numCourses;
    }

    //Solution 2: DFS with Cycle Detection
    //Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisites.
    //Space Complexity: O(V + E) for the adjacency list and recursion stack.
    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int adjacentNode : adj.get(node)) {
            if (vis[adjacentNode] == 0) {
                if (dfs(adjacentNode, node, vis, adj) == true)
                    return true;
            } else if (adjacentNode != parent)
                return true;
        }
        return false;
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0)
                if (dfs(i, -1, vis, adj) == true)
                    return true;
        }
        return false;
    }
} 
