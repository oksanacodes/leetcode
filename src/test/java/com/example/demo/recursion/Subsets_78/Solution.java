package com.example.demo.recursion.Subsets_78;

/*
78. Subsets  https://leetcode.com/problems/subsets/description/
Given an integer array nums of unique elements, return all possible
subsets

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

SOLUTION: Youtube video
https://www.youtube.com/watch?v=3tpjp5h3M6Y
https://www.youtube.com/watch?v=SHsGi38sHSQ
https://www.youtube.com/watch?v=LdtQAYdYLcE


 */


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    Runtime Complexity is O(N×2^N)
    For a given number, it could be present or absent (i.e. binary choice) in a subset solution. As as result, for N numbers, we would have in total
2^N choices (solutions). But every subset could have N characters.

In other words, 2^N is the number of subsets. But we dont want to return number of subsets. We want to know the runtime.
Every subset has N candidates in the begining to explore. So runtime complexity is O(N*2^N)

space complexity is O(N) is the recursion stack
     */

    List<List<Integer>> subsets;
    int[]nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.subsets = new ArrayList<>();
        this.nums=nums;
        backTrack(0,new ArrayList());
        return subsets;
    }
    public void backTrack(int index, List<Integer> combo){
        // if we reached the end of the array and explored all candidates, add the final candidate to the the result list
        if(index>= nums.length){
            subsets.add(new ArrayList<>(combo));
            return;
        }else{


            //case 1: include element
            combo.add(nums[index]);
            backTrack(index+1,combo);

            //case2: do not include element
            combo.remove(combo.size()-1);
            backTrack(index+1, combo);
        }
    }
    @Test
     public void t(){
        int[]nums={1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);

    }
}
