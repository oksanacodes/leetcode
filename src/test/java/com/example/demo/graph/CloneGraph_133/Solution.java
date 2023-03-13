package com.example.demo.graph.CloneGraph_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
133. Clone Graph https://leetcode.com/problems/clone-graph/description/
Youtube Solution https://www.youtube.com/watch?v=e5tNvT1iUXs
 */
public class Solution {

    private HashMap<Integer, Node> visited;
    public Node cloneGraph(Node node) {
        this.visited = new HashMap();
        if (node==null){
            return null;
        }
        Node clone =clone(node);
        return clone;
    }


    /*
    Thought process for DFS solution:
    1) Create a map visited that keeps track of all cloned nodes created where key is an integer and value is the list of neighbors
    1-> Node; where Node is the cloned node

    Time Complexity: O(N+M), where N is a number of nodes (vertices) and M is a number of edges.
    Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that,
    space would also be occupied by the recursion stack since we are adopting a recursive approach here.
    The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph.
    Overall, the space complexity would be O(N);

     */

    private Node clone(Node node){
        // base case when node == 1, we are done
        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if(visited.containsKey(node.val)){
            return visited.get(node.val);
        }
        // create  a copy of the node and mark it as visited
        // Note that we don't have cloned neighbors as of now, hence [].
        Node copy = new Node(node.val);
        visited.put(node.val, copy);
        //neighbors
        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for(Node neighbor: node.neighbors){
            Node clonedNeigbor = clone(neighbor);
            visited.get(node.val).neighbors.add(clonedNeigbor);
        }
        return copy;
    }

}

