package com.example.demo.graph.NumberOfIslands_200;
/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/description/

 */
public class Solution {

    /*
    Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a
    Depth First Search. During DFS, every visited node should be set as '0' to mark as visited node.
    Count the number of root nodes that trigger DFS, this number would be the number of islands
    since each DFS starting at some root identifies an island.

    Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

    Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N  deep.
     */

    public void visit(char[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length
                || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        visit(grid, row+1, col);
        visit(grid, row-1, col);
        visit(grid, row, col+1);
        visit(grid, row, col-1);

    }
    public int numIslands(char[][] grid) {
        System.out.println(" grid "+grid[0]);
        int nR=grid.length;
        int nC= grid[0].length;
        int numOfIslands=0;

        for(int row=0; row<nR; row++){
            for(int col = 0; col<nC; col++){
                if(grid[row][col]=='1'){
                    numOfIslands++;
                    visit(grid, row, col);
                }
            }
        }
        return numOfIslands;
    }
}
