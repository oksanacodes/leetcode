package com.example.demo.graph.AllPathsFromSourceToTarget_797;

import org.junit.jupiter.api.Test;

import java.util.*;

/*
797. All Paths From Source to Target https://leetcode.com/problems/all-paths-from-source-to-target/description/

Youtube explanation  https://www.youtube.com/watch?v=CYnvDzMprdc

Runtime Complexity: O(2^n * n^2).
2^n - for every single path we can have two cases: 1) that current node is in the path or 2) node is not in the path;
So we could have 2^n paths
n^2 - due to the fact that we have to copy  the whole array that holds an old path (line 39) for every single neighbor (line 38)

Space Complexity: O(2^n * n) becuase we have 2^n results taht we have to add to our queue.And the length of each path can be up to n elements

 */
public class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        int n = graph.length-1;
        int destination = graph.length-1;

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0));

        while(!queue.isEmpty()){
            List<Integer> path = queue.poll();
            int size = path.size();
            int lastNode = path.get(size-1);
            if(lastNode==destination){
                result.add(new ArrayList<>(path));
            }else{
                int [] neighbors =graph[lastNode];
                for(int neighbor: neighbors){
                    List<Integer> pathUpdated = new ArrayList<>(path);
                    pathUpdated.add(neighbor);
                    queue.add(pathUpdated);
                }
            }
        }
        return result;
    }
    @Test
    public void t(){
        int [][]graph = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>>  result =allPathsSourceTarget(graph);
        //expected output Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
        System.out.println(result);
    }
}
