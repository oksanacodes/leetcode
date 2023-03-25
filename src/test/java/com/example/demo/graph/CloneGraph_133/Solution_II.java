package com.example.demo.graph.CloneGraph_133;

import java.util.HashMap;

/*
133. Clone Graph https://leetcode.com/problems/clone-graph/description/
Youtube Solution https://www.youtube.com/watch?v=e5tNvT1iUXs
 */
public class Solution_II {


    /*
    Thought process for this solution:
    1) Create a map visited that keeps track of all cloned nodes created where key is an original ode and value is the clonned node
    1-> 1'; where 1' is the cloned node

    Time Complexity: O(N+M), where N is a number of nodes (vertices) and M is a number of edges.
    Space Complexity: O(N). This space is occupied by the visited hash map and in addition to that,
    space would also be occupied by the recursion stack since we are adopting a recursive approach here.
    The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph.
    Overall, the space complexity would be O(N);

     */

    private HashMap<Node, Node> visited;
    public Node cloneGraph(Node node) {
        this.visited = new HashMap();
        if (node==null){
            return null;
        }
        Node clone =clone(node);
        return clone;
    }

    private Node clone(Node node){
        //base case - If the node was already visited before.Return the clone from the visited dictionary.
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        // create  a copy of the node and mark it as visited.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node copy = new Node(node.val);
        visited.put(node, copy);
        //neighbors
        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for(Node originalChild: node.neighbors){
            Node clonedChild = clone(originalChild);
            copy.neighbors.add(clonedChild);
        }
        return copy;
    }

}

