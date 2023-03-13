package com.example.demo.graph.NetworkDelayTime_743;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {

    class Edge{
        int destination;
        int weight;
        Edge(int weight, int destination){
            this.destination= destination;
            this.weight = weight;
        }

        public int getWeight(){
            return weight;
        }
        public int getDestination(){
            return destination;
        }

        public void setDestination(int destination){
            this.destination = destination;
        }
        public void setWeight(int weight){
            this.weight = weight;
        }
        public String toString(){
            return "weight "+weight+" destination "+destination;
        }
    }
    /*

    https://leetcode.com/problems/network-delay-time/submissions/892272687/

    Youtube solution: https://www.youtube.com/watch?v=EaphyqKU4PQ
    Time complexity: O(V+E*log(V)) -Operations in priority queue takes log(N) times. The max number of vertices added to the priority
    queue is V*(V-1) = V^2 ~ E. The save V can be added to the queue multiple times depending on the number of edges Thus, time complexity is E log(V);
    Space complexity: O(V+E). Building the adjacency list will take O(E) space. Adding vertice to the queue will take O(V) time



     */
    public int networkDelayTime(int[][] times, int n, int k) {
        int result=0;

        //1. Create adjacency list
        Map<Integer, List<Edge>> map = new HashMap<>();
        for(int []time: times){
            int source = time[0];
            int destination = time[1];
            int weight = time[2];
            map.computeIfAbsent(source, val->new ArrayList()).add(new Edge(weight,destination));
        }
        System.out.println(map);

        // create minHeap which will give us the shortest path from the node to the destination
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b)->a.getWeight()-b.getWeight());
        Set<Integer> visited = new HashSet<>();
        minHeap.add(new Edge(0,k));
        while(!minHeap.isEmpty()){
            Edge topElement = minHeap.poll();
            int currentWeight  = topElement.getWeight();
            int currentNode = topElement.getDestination();
            if(visited.contains(currentNode)){
                continue;
            }
            // mark as visited
            visited.add(currentNode);
            // update shortestTime
            result=Math.max(result,currentWeight);

            //get all neighbors of that node
            List<Edge> neighbors = map.get(currentNode);
            if(neighbors==null){
                continue;
            }
            for(Edge neighbor: neighbors){
                if(visited.contains(neighbor)){
                    continue;
                }
                int totalPath = neighbor.getWeight()+currentWeight;
                minHeap.add(new Edge(totalPath, neighbor.getDestination()));
            }
        }


        if(n== visited.size()){
            return result;
        }
        // we didnt visit all nodes
        return -1;

    }

    @Test
    public void t(){
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        int result = networkDelayTime(times,n,k);
        Assertions.assertEquals(2,result);
    }
}
