package com.example.demo.graph.MinCostToConnectAllPoints_1584;



import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
1584. Min Cost to Connect All Points
https://leetcode.com/problems/min-cost-to-connect-all-points/description/



 */
public class Solution {

    private class Edge{
        int vertex;
        int cost;
        public Edge(int cost, int vertex){
            this.vertex=vertex;
            this.cost=cost;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }

    /*
    Youtube Solution https://www.youtube.com/watch?v=f7JOBJIC-NA

    Prim's Algorithm.
    Pick an arbitrary point. And keep adding the lowest weighed edge from the nodes present in MST until
    all nodes are present in MST and no cycles are formed
    Time - In the worst case scenario we have to push N*(N-1) edges to the heap. Poping and adding an element t
    to the heap takes O(logN) time
    Space - In the worst case scenario we have to push N*(N-1) edges to the heap ~ O(N^2);
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minCost=0;
        int edgesUsed=0;
        // Min-heap to store minimum weight edge at top.
        PriorityQueue<Edge> heap =
                new PriorityQueue<>((x,y)->x.cost-y.cost);

        // Track nodes which are included in MST.
       Set<Integer> visited = new HashSet<>();

        heap.add(new Edge(0,0));


        while(edgesUsed<n){
            Edge topElement = heap.poll();
            int currentCost = topElement.getCost();
            int currentNode = topElement.getVertex();

            // If node was already included in MST we will discard this edge.
            if(visited.contains(currentNode)){
                continue;
            }
            minCost = minCost+currentCost;
            edgesUsed++;
            visited.add(currentNode);

            // If next node is not in MST, then edge from curr node
            // to next node can be pushed in the priority queue.
            for(int newNode=0; newNode<n;newNode++){
                if(visited.contains(newNode)){
                    continue;
                }
                int newCost = Math.abs(points[currentNode][0]-points[newNode][0])+
                        Math.abs(points[currentNode][1]-points[newNode][1]);
                heap.add(new Edge(newCost, newNode));
            }
        }

        return minCost;
    }

   @Test
    public void t(){
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int result = minCostConnectPoints(points);
       System.out.println(result);
        assert  result==20;
    }


}
