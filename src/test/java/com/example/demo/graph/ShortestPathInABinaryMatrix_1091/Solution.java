package com.example.demo.graph.ShortestPathInABinaryMatrix_1091;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    /*
    Youtube solution https://www.youtube.com/watch?v=dK76rXBQ_IA
    Thought process:
    1) define all possible directions from the node at the position (0,0);
    2) every single time when you visit the node, mark it
    3) do BST
    Time complexity : O(N) where N is the number of cells; Processing a cell is O(1), and each of the N cells is processed at most once, giving a total of O(N).
    Space complexity : O(N). The visited set also requires O(N) space; in the worst case, it will hold the row and column of each of the N cells.
     */

    public int shortestPathBinaryMatrix(int[][] grid) {
        // Firstly, we need to check that the start and target cells are open.
        if(grid[0][0]==1 && grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }

        int [][]directions=  new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Queue<int[]>queue=new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.add(new int[]{0, 0, 1});
        visited[0][0]=true;
        while(!queue.isEmpty()){
            int[] path = queue.poll();
            int x=path[0];
            int y=path[1];
            int d =path[2];
            if(x==grid.length-1 && y==grid[0].length-1){
                return d;
            }

            for (int[]direction: directions){
                int newX = x+direction[0];
                int newY = y+direction[1];
                if(newY>=0 && newY<grid[0].length && newX>=0 && newX<grid.length && grid[newX][newY]==0){
                    path[0]=newX;
                    path[1]= newY;
                    path[2]=d+1;
                    if(visited[newX][newY]){
                        continue;
                    }
                    visited[newX][newY]=true;
                    queue.add(path);

                }
            }
        }

        return -1;
    }


    @Test
    public void t(){
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int returnValue = shortestPathBinaryMatrix(grid);
        System.out.println(returnValue);
        assert returnValue==4;
    }

}
