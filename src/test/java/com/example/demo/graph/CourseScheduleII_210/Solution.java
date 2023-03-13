package com.example.demo.graph.CourseScheduleII_210;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    /*
    Problem overview https://leetcode.com/problems/course-schedule-ii/description/
    Youtube Solution https://www.youtube.com/watch?v=33vK4AqXjag

    Topological sort
    1) Create adjacency list where you keep the track of every node's neighbors
    2) Create an array of nodes that keep track of indegree edgees
    3) Create a queue that has only nodes where in-degree == 0. If there are no nodes with in-degree 0, it means
    our graph is a cycle and return [].
    4) Remove the node from the queue and decrease the number of in-degrees of its neihbors. If during this decrease,
    the neibhor's indegree becomes 0, add i to the queue. Keep doing it until queue is empty
    5) in the end check if number of courses == size of your output

    Runtime: O(V+E) where V is the number of courses and E is the prerequsites.length.
    Each node is pushed into the queue once. For each node we iterate trough its neighbors.
    Space: O(V+E). Queue in the worst case would have all nodes (courses dont have prereq, all of them
    have 0 in-degrees).It takes O(E) to construct adjacency list, we need to visit every edge at least once.
     */

    public int[] findOrder(int numCourses, int[][] prerequisites){
        //1. Create adjacency list
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree= new int[numCourses];
        int [] output = new int[numCourses];
        for(int[] prereq: prerequisites){
            int source= prereq[1];
            int destination = prereq[0];
            //1->3  2->3
            map.computeIfAbsent(source, val->new ArrayList<>()).add(destination);
            indegree[destination]++;
        }
        System.out.println("map"+map);

        //2. Add nodes with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        //3. We have a cycle if none nodes have 0 in-degrees
        while(queue.isEmpty()){
            return new int[]{};
        }

        //4. Start BFS
        int k=0;
        while(!queue.isEmpty()){
            int element = queue.poll();
            output[k++]=element;
            List<Integer> neighbors = map.get(element);
            if(neighbors==null){
                continue;
            }
            for(int neigbor:neighbors){
                indegree[neigbor]--;
                if(indegree[neigbor]==0){
                    queue.add(neigbor);
                }
            }
        }
        //5. check if all courses were added
        if(numCourses == k){
            return output;
        }

        return new int[]{};
    }

    @Test
    public void t(){
        /*
        Explanation: There are a total of 4 courses to take.
        To take course 3 you should have finished both courses 1 and 2.
        Both courses 1 and 2 should be taken after you finished course 0.
        So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
         */
        int numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        int[]result = findOrder(numCourses, prerequisites);
        List<Integer> r= Arrays.stream(result).boxed().collect(Collectors.toList());

        System.out.println(r);
    }


}
