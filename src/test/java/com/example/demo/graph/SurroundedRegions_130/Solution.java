package com.example.demo.graph.SurroundedRegions_130;


/*
130. Surrounded Regions https://leetcode.com/problems/surrounded-regions/description/

There are 3 types of cells: 1) 'x' - wall; 2) 'O' - captured; 3) 'T' - connected to the border
Start at the borders (first column, last column, first row, last row) and look for the cells equal to 'O' which will trigger dfs
to explore surrounding cells.

Runtime: O(R*C) - we need to visit all cells. And dfs function runs only once for each cell.
Space: O(R*C) - size of recursion stack. In the worst case the whole grid is filled with 'O'.

 */
public class Solution {

    int ROWS;
    int COLUMNS;
    char[][]board;
    boolean[][]visited;

    public void solve(char[][] board) {
        this.ROWS = board.length;
        this.COLUMNS = board[0].length;
        this.board=board;

        // 1a) Loop through all cells at the border top and bottom row (O -> T)
        // Start with the cell that is 1) on the border and 2) equal to 'O'. Mark the cell that is connected to the border as 'T'
        for(int c=0;c<COLUMNS;c++){
            if(board[0][c]=='O'){
                dfs(0,c);
            }
            if(board[ROWS-1][c]=='O'){
                dfs(ROWS-1,c);
            }
        }
        // 1b) Capture unsurrounded regions - Left and right columns (O -> T)
        for(int r=0; r<ROWS; r++){
            if(this.board[r][0] =='O'){
                dfs(r,0);
            }

            if(this.board[r][COLUMNS-1]=='O'){
                dfs(r, COLUMNS-1);
            }
        }
// in the end there are 3 types of cells at this point 'x' - wall; 'O' - cells that have no connection to the border; therefore, they are captured;
// 'T' - cells that has connection to the border, therefore they are not captured
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLUMNS;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';   // 2) Capture surrounded regions (O -> X)
                }else if(board[r][c]=='T'){
                    board[r][c]='O';   // 3) Uncapture unsurrounded regions (T- O)
                }
            }
        }
    }

    private void dfs( int r, int c) {

        if (
                r < 0 || c < 0 || r >= ROWS || c >= COLUMNS
        ) return;

        if(board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';
        dfs( r + 1, c);
        dfs( r - 1, c);
        dfs( r, c + 1);
        dfs( r, c - 1);
    }
}