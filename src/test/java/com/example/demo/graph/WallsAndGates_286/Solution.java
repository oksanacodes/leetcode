package com.example.demo.graph.WallsAndGates_286;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 286. Walls and Gates
 https://leetcode.com/problems/walls-and-gates/#/description
 You are given a m x n 2D grid initialized with these three possible values.
 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent
 INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible
 to reach a gate, it should be filled with INF.
 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 Thought process:
 1. Find positions of all GATES and add their coordinates to the queue.
 2. While queue is not empty, get the current position of the gate and move its point up and down, left and right. Determine whether new coordinate is a valid point
 by checking boundaries of the matrix. Another edge case to check is not to override the value that is equal to something that is not INFINITY.
 3. if the new coordinate is valid, increase its value by 1 and add to the queue.


 Runtime: O(R*C) - we need to visit all cells. And dfs function runs only once for each cell.
 Space: O(R*C) - size of recursion stack. In the worst case the whole grid is filled with gates.
 */

public class Solution {


    @Test
    public void t(){
        int[][] rooms = new int[][] {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE,Integer.MAX_VALUE,},};

        int [][] newRooms = wasllsAndGates(rooms);

        for (int[] room :newRooms){
            System.out.println(room);
        }
    }



    @Data
    public class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] wasllsAndGates(int[][] rooms) {
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        Queue<Point> q = new LinkedList<>();
        int emptyRoom = Integer.MAX_VALUE;
        int gate = 0;
        int wall= -1;


        for(int row=0; row<rooms.length; row ++){
            for(int col=0; col<rooms[row].length;col++){
                if(rooms[row][col]==gate){
                    q.add(new Point(row,col));
                }
            }
        }
        System.out.println(q);

        while(!q.isEmpty()){
            Point currpoint = q.poll();
            for(int[] point: directions){
                Point newCoordinate = new Point(currpoint.row+point[0], currpoint.col+point[1]);
                if(newCoordinate.row<0 || newCoordinate.col<0||
                newCoordinate.row>=rooms.length || newCoordinate.col>=rooms[0].length ||
                rooms[newCoordinate.row][newCoordinate.col] !=Integer.MAX_VALUE
                ){
                    continue;
                }else{
                    rooms[newCoordinate.row][newCoordinate.col]=rooms[currpoint.row][currpoint.col]+1;
                    q.add(new Point(newCoordinate.row, newCoordinate.col));
                }
            }
        }
        return rooms;


    }
}
