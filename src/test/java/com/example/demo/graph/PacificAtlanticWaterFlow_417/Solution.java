package com.example.demo.graph.PacificAtlanticWaterFlow_417;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.RowWriterProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
417. Pacific Atlantic Water Flow
https://leetcode.com/problems/pacific-atlantic-water-flow/description/

Space: O(R*C) - size of the recursion stack
Runtime:  O(R*C) - every cell will be visited at least once. The dfs function runs exactly once for each cell
accessible from an ocean.

 */
public class Solution {

    List<List<Integer>> result;
    int[][]heights;
    int ROWS;
    int COLUMNS;
    boolean[][] pacificResult;
    boolean[][] atlanticResult;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.result = new ArrayList<>();
        this.heights=heights;
        this.ROWS=heights.length;
        this.COLUMNS=heights[0].length;

        // loop through each cell adjacent to the ocean
        pacific();
        atlantic();

        //at this point pacitic and atlantic arrays contain coordinates of the cells that can reach their respective ocean
        // now lets find the cells that can reach both pacific and atlantic ocean

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLUMNS; c++){
                if(pacificResult[r][c] && atlanticResult[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        return result;
    }

    public void dfs(int r,int c, int previous, boolean[][] visit){
        // check the new cell is within the bounds
        if(r<0 || r>=ROWS || c<0 || c>=COLUMNS){
            return;
        }
        // check if th new cell has been visited
        if(visit[r][c]){
            return;
        }
        // check that the new cell is reachable
        if(previous > this.heights[r][c]){
            return;
        }

        // mark cell as reachable
        visit[r][c]=true;

        // visit all 4 neighbors of the cell

        dfs(r+1,c, heights[r][c], visit);
        dfs(r-1,c, heights[r][c], visit);
        dfs(r,c+1, heights[r][c], visit);
        dfs(r,c-1, heights[r][c], visit);
    }

    public void pacific(){

        // Pacific ocean borders to 1st row and 1st column. Start from the cell  of first row and 1st column
        // to see which node can reach the Pactific ocean

        for(int c=0;c<COLUMNS;c++){
            dfs(0,c, Integer.MIN_VALUE,pacificResult);
        }

        for(int r=0;r< ROWS;r++) {
            dfs(r,0, Integer.MIN_VALUE, pacificResult);
        }
    }

    public void atlantic(){
        // Atlantic ocean borders with last row and last column. Start from the cell  of the last row and last
        // column to see which node can reach the Atlantic ocean

        for(int c=0; c<COLUMNS; c++){
            dfs(ROWS-1, c, Integer.MIN_VALUE, atlanticResult);
        }

        for(int r=0;r<ROWS;r++){
            dfs(r, COLUMNS-1, Integer.MIN_VALUE, atlanticResult);
        }
    }



}
