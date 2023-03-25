package com.example.demo.graph.MaxAreaOfIsland_695;

/*
695. Max Area of Island https://leetcode.com/problems/max-area-of-island/


You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.


Runtime is O(R*C) - cause we visit every cell at least once, where R is number of rows and C is number of columns
Space is O(r*c) - size of recursion stack

Problem similar to 200. Number of islands, but here instead of counting nubmer of islands we count max area

 */
public class Solution {

    int[][]grid;
    int maxArea;
    int ROWS;
    int COLUMNS;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        this.maxArea=0;
        this.ROWS=grid.length;
        this.COLUMNS= grid[0].length;

        for(int r=0;r<ROWS; r++){
            for(int c=0;c<COLUMNS;c++){
                if(grid[r][c]==1){
                    int localArea= visit(r,c);
                    maxArea=Math.max(maxArea,localArea);
                }
            }
        }

        return maxArea;
    }

    private int visit(int r, int c){
        if(r<0 || r>=ROWS ||
                c<0 || c>=COLUMNS || grid[r][c]==0){
            return 0;
        }
        grid[r][c]=0;
        return 1+visit(r+1,c) +visit(r-1,c) + visit(r,c+1)+visit(r,c-1);
    }
}
