package com.example.demo.graph.FindIfPathExistsInGraph_1971;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
1971. Find if Path Exists in Graph
https://leetcode.com/problems/find-if-path-exists-in-graph/description/

Solution Youtube https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/3847/

Time complexity: O(V+E)
Space complexity: O(V+E)

 */
public class SolutionDFS {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Store all edges according to nodes in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        System.out.println(graph);

        // Start from source node, add it to stack.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while(!stack.isEmpty()){
            int currentNode = stack.pop();
            if(currentNode == destination){
                return true;
            }
            // Add all unvisited neighbors of the current node to stack'
            // and mark it as visited.
            List<Integer> neighbors = graph.get(currentNode);
            for(int neigbor: neighbors){
                if(seen[neigbor]==false){
                    stack.push(neigbor);
                    seen[neigbor]=true;
                }
            }
        }
        return true;
    }

    @Test
    public void t(){
        int n = 3;
        int [][]edges ={{0,1}, {1,2}, {2,0}};
        int source = 0;
        int destination = 2;
        boolean result = validPath(n,edges,source, destination);
        assert result;
    }
}
