package com.example.demo.graph.CheapestFlightsWithinKStops_787;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    /*
    https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
    Solution https://www.youtube.com/watch?v=5eIK3zUdYmE


    Let E be the number of flights and N be the number of cities.

Time complexity: O(N+E*K)
Depending on improvements in the shortest distance for each node, we may process each edge multiple times.
However, the maximum number of times an edge can be processed is limited by K because that is the number of levels we
will investigate in this algorithm. In the worst case, this takes O(E⋅K) time. We also need O(E) to initialize the adjacency
list and O(N) to initialize the dist array.

Space complexity: O(N+E⋅K)

We are processing at most E*K edges, so the queue takes up O(E⋅K) space in the worst case.
We also need O(E) space for the adjacency list and O(N) space for the dist array.
     */

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        //1. Create adjacency list
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[]flight:flights){
            int source = flight[0];
            int destination = flight[1];
            int cost = flight[2];
            map.computeIfAbsent(source, value->new ArrayList<>()).add(new int[]{destination, cost});
        }
        //2. Create an array that keeps track of the mincost from source to destination where n is the number of cities
        // Fill in all values of the array with infinity values. In the end if the minCost[dest]=INTEGER.MAX.VALUE, we know we couldnt find the path within k stops
        int[]minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        int stops=0;
        //3. Do BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src,0});
        minCost[src]=0;

        while(!queue.isEmpty() && k>=stops){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[]element = queue.poll();
                int currentNode = element[0];
                int currentCost = element[1];

                List<int[]> neigbors = map.get(currentNode);
                if(neigbors==null){
                    continue;
                }

                for(int[] neighbor: neigbors){
                    int newNode = neighbor[0];
                    int newCost = neighbor[1];
                    int totalCost = newCost+currentCost;
                    if(minCost[newNode]>totalCost){
                        minCost[newNode]=totalCost;
                        queue.add(new int[]{newNode, totalCost});
                    }
                }
            }
            stops++;
        }

        if(minCost[dst]!=Integer.MAX_VALUE){
            return minCost[dst];
        }

        return -1;
    }

    @Test
    public void t(){
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;

        int result = findCheapestPrice(n, flights, src, dst,k);
        Assertions.assertEquals(700, result);

    }
}
