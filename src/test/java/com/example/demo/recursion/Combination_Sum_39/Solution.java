package com.example.demo.recursion.Combination_Sum_39;


import java.util.ArrayList;
import java.util.List;

/*
39. Combination Sum https://leetcode.com/problems/combination-sum/description/

Backtracking is a general algorithm for finding all (or some) solutions to some computational problems.
The idea is that it incrementally builds candidates to the solutions,
and abandons a candidate ("backtrack") as soon as it determines that this candidate cannot lead to a
final solution.

Decesiion tree: add element or not add element
Runtime: O(2^target) or 2^height. Height is the target.

 */
public class Solution {

    private int[] candidates;
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.result = new ArrayList<>();
        backtracking(0,target, new ArrayList<>());
        return result;
    }

    private void backtracking(int i, int target, List<Integer> combo){
        if(target==0){
            result.add(new ArrayList(combo));
            return;
        }
        if(target<0|| i>=candidates.length ){
            return;
        }
        // case 1: add element
        combo.add(candidates[i]);
        backtracking(i, target-candidates[i], combo);

        //case 2: do not add element
        combo.remove(combo.size()-1);
        backtracking(i+1, target, combo);
    }
}
