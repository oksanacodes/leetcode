package com.example.demo.recursion.Combination_Sum_II_40;


import java.util.ArrayList;
import java.util.List;

/*
40. Combination Sum II https://leetcode.com/problems/combination-sum-ii/description/

Backtracking is a general algorithm for finding all (or some) solutions to some computational problems.
The idea is that it incrementally builds candidates to the solutions,
and abandons a candidate ("backtrack") as soon as it determines that this candidate cannot lead to a
final solution.

Decesion tree: add element or not add element
Runtime: O(2^n)
Space time is O(n) - size or recursion stack
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
        backtracking(i+1, target-candidates[i], combo);

        //case 2: do not add element
        combo.remove(combo.size()-1);
        while(i+1< candidates.length && candidates[i]==candidates[i+1]){
            i++;
        }
        backtracking(i+1, target, combo);
    }
}
