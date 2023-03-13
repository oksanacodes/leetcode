package com.example.demo.graph.RottingOranges_994;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/*
994. Rotting Oranges https://leetcode.com/problems/rotting-oranges/description/
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 */
public class Solution {
    /*
    Video solution is https://www.youtube.com/watch?v=vsAeM9EGhFo

    Thought process:
    1. find quantity of fresh oranges g[i][j]==1
    2. Find the positions of rotten oranges and add them to the queue.Every single time when you see a rotten orange,
    check its neighbors. If the neighbor is a fresh orange, turn it into rotten orange grid[i][j]==2
    and decrese the number of fresh oranges
    3. Stop the algorithm when you dont have any freshoranges left or there are no elements in the queue

    Time: O(row*column) - need to process every element in the grid at least once when we do  first linear scan
    Then we start the BFS (while loop), that would also take O(row*column) to check all neighboring positions.
    Space: O(row* column) - number of the rotten oranges in the queue.
     */
    public int orangesRotting(int[][] grid) {
        int freshOranges=0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for (int j=0; j<grid[i].length;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        System.out.println("Fresh oranges is "+freshOranges);

        int [][]directions={{0,-1}, {0,1}, {1,0}, {-1,0}};

        int minutes=0;

        while(!queue.isEmpty() && freshOranges>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] path = queue.poll();
                int x = path[0];
                int y = path[1];
            for(int[]direction:directions){
                int newX = x+ direction[0];
                int newY = y+direction[1];
                if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length && grid[newX][newY]==1){

                        freshOranges--;
                    // this orange would be contaminated
                        grid[newX][newY]=2;
                    // this orange would then contaminate other oranges
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
            minutes++;
            }
        if(freshOranges==0) {
            return minutes;
        }

        System.out.println(minutes);
    return -1;

    }


    @Test
    public void t(){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int returnValue = orangesRotting(grid);
        System.out.println(returnValue);
        assert returnValue==4;
    }
}
