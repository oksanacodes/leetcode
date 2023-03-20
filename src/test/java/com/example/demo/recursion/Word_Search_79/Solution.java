package com.example.demo.recursion.Word_Search_79;

/*
79. Word Search https://leetcode.com/problems/word-search/description/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Runtime is O(r*c* 4^(N)), where r*c is the total number of cells in the matrix that needed to be explored.
For every single cell, we need to make 4 choices: to go up, down, left,right. And we need to keep making these choices
until we run out of letters inthe word (N is the length of the word).

Space is O(N) where N is the length of the word
 */
public class Solution {

    int ROWS;
    int COLUMNS;
    String word;
    char[][]board;


    public boolean exist(char[][] board, String word){
        this.ROWS=board.length;
        this.COLUMNS = board[0].length;
        this.word=word;
        this.board=board;

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLUMNS;c++){
                if(dfs(r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i){
        if(i==this.word.length()){
            return true;
        }

        if(r<0 || c<0 ||
        r>=ROWS || c>=COLUMNS ||
        this.board[r][c]!= this.word.charAt(i)){
            return false;
        }


        boolean result = dfs(r+1, c, i+1)||
                dfs(r-1, c,i+1) ||
                dfs(r,c+1,i+1) ||
                dfs(r, c-1,i+1);

        return result;

    }


}
