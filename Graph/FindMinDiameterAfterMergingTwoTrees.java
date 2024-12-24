package Graph;

import java.util.*;

public class FindMinDiameterAfterMergingTwoTrees {
    /**
     * 3203. Find Minimum Diameter After Merging Two Trees
     * There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.
     *
     * You must connect one node from the first tree with another node from the second tree with an edge.
     *
     * Return the minimum possible diameter of the resulting tree.
     *
     * The diameter of a tree is the length of the longest path between any two nodes in the tree.
     *
     *
     *
     * Example 1:
     *
     * Input: edges1 = [[0,1],[0,2],[0,3]], edges2 = [[0,1]]
     *
     * Output: 3
     *
     * Explanation:
     *
     * We can obtain a tree of diameter 3 by connecting node 0 from the first tree with any node from the second tree.
     *
     * Example 2:
     *
     *
     * Input: edges1 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = [[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]
     *
     * Output: 5
     *
     * Explanation:
     *
     * We can obtain a tree of diameter 5 by connecting node 0 from the first tree with node 0 from the second tree.
     *
     *
     *
     * Constraints:
     *
     * 1 <= n, m <= 105
     * edges1.length == n - 1
     * edges2.length == m - 1
     * edges1[i].length == edges2[i].length == 2
     * edges1[i] = [ai, bi]
     * 0 <= ai, bi < n
     * edges2[i] = [ui, vi]
     * 0 <= ui, vi < m
     * The input is generated such that edges1 and edges2 represent valid trees.
     * */
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{0,3}};
        int[][] edges2 = {{0,1}};
        System.out.println(minimumDiameterAfterMerge(edges1, edges2));
    }

    //Approach (Using BFS)
    //T.C : O(V+E)
    //S.C : O(V+E)
    public static Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }

    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> adj1 = buildAdjList(edges1);
        Map<Integer, List<Integer>> adj2 = buildAdjList(edges2);

        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;
        return Math.max(Math.max(d1, d2), combined);
    }

    public static int findDiameter(Map<Integer, List<Integer>> adjList) {
        List<Integer> farthestNode = BFS(adjList, 0);

        farthestNode = BFS(adjList, farthestNode.get(0));
        return farthestNode.get(1);
    }

    public static List<Integer> BFS(Map<Integer, List<Integer>> adjList, int sourceNode) {
        Queue<Integer> que = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        que.add(sourceNode);
        visited.put(sourceNode, true);

        int maxDistance = 0, farthestNode = sourceNode;

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int currentNode = que.poll();
                farthestNode = currentNode;

                for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited.getOrDefault(neighbor, false)) {
                        visited.put(neighbor, true);
                        que.add(neighbor);
                    }
                }
            }
            if (!que.isEmpty()) {
                maxDistance++;
            }
        }
        return Arrays.asList(farthestNode, maxDistance);
    }
}
