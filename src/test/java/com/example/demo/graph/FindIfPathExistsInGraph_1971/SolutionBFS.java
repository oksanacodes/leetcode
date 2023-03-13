package com.example.demo.graph.FindIfPathExistsInGraph_1971;

import org.junit.jupiter.api.Test;

import java.util.*;
/*
Time Complexity:  O(V+E). Here, V represents the number of vertices and E represents the number of edges.
To create the adjacency list, we must iterate over each of the E edges.

Space Complexity: O(V+E).The adjacency list, will contain O(V+E) elements.
The queue will also contain O(V) elements.
The visited set will use O(V) space to store the visited nodes.
 */

public class SolutionBFS {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int[] edge: edges){
            int v1 = edge[0];
            int v2 = edge[1];
            map.computeIfAbsent(v1,value-> new ArrayList<>()).add(v2);
            map.computeIfAbsent(v2, value-> new ArrayList<>()).add(v1);
        }
        boolean[]visited = new boolean[n];
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(source));
        visited[source]=true;

        while(!queue.isEmpty()){
            List<Integer> path = queue.poll();
            int size = path.size();
            int lastNode = path.get(size-1);
            if(lastNode==destination){
                return true;
            }
                List<Integer>neighbors = map.get(lastNode);
                for(int neigbor: neighbors){
                    if(!visited[neigbor]){
                        visited[neigbor]=true;
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(neigbor);
                        queue.add(newPath);
                    }
                }
        }
    return false;
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
