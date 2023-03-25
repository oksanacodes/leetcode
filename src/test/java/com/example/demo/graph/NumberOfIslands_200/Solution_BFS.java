package com.example.demo.graph.NumberOfIslands_200;

import java.util.LinkedList;
import java.util.Queue;

/*
200. Number of Islands
https://leetcode.com/problems/number-of-islands/description/

 */
public class Solution_BFS {

    /*
    Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a
    Breadth First Search. During BFS, every island be set as '0' to mark as visited node and added to the queue.
    Keep exploring neighbors of nodes on the queue iteratively until queue becomes empty.

    Count the number of root nodes that trigger BFS, this number would be the number of islands
    since each BFS starting at some root identifies an island.

    Time complexity : O(M×N) where M is the number of rows and N is the number of columns.

    Space complexity : worst case O min (M×N) because in worst case where the grid is filled with lands,
    the size of queue can grow up to min(M,N).
     */

    class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    public int numIslands(char[][] grid) {
        System.out.println(" grid "+grid[0]);
        int nR=grid.length;
        int nC= grid[0].length;
        int numOfIslands=0;
        Queue<Point> neighbors = new LinkedList<>();

        for(int row=0; row<nR; row++){
            for(int col = 0; col<nC; col++){
                if(grid[row][col]=='1'){
                    numOfIslands++;
                    neighbors.add(new Point(row,col));
                    while(!neighbors.isEmpty()){
                        Point point = neighbors.poll();
                        int r = point.r;
                        int c = point.c;
                        grid[r][c]='#';
                        if(r+1<nR && grid[r+1][c]=='1'){
                            grid[r+1][c]='#';
                            neighbors.add(new Point(r+1,c));
                        }
                        if(r-1>0 && grid[r-1][c]=='1'){
                            grid[r-1][c]='#';
                            neighbors.add(new Point(r-1,c));
                        }

                        if(c+1<nC && grid[r][c+1]=='1'){
                            grid[r][c+1]='#';
                            neighbors.add(new Point(r,c+1));
                        }

                        if(c-1>0 && grid[r][c-1]=='1'){
                            grid[r][c-1]='#';
                            neighbors.add(new Point(r,c-1));
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }
}
