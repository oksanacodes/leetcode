package com.example.demo.recursion.Subsets_II_90;

/*
90. Subsets  II  https://leetcode.com/problems/subsets-ii/description/
Given an integer array nums that may contain duplicates, return all possible
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

 */


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
    Runtime Complexity is O(N×2^N)
    For a given number, it could be present or absent (i.e. binary choice) in a subset solution. As as result, for N numbers, we would have in total
2^N choices (solutions). But every subset could have N characters.

Sorting nums array is O(N*logN). But since N*2^N is bigger, its disregarded

In other words, 2^N is the number of subsets. But we dont want to return number of subsets. We want to know the runtime.
Every subset has N candidates in the begining to explore. So runtime complexity is O(N*2^N)

space complexity is O(N) is the recursion stack
     */

    List<List<Integer>> subsets;
    int[]nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.subsets = new ArrayList<>();
        this.nums=nums;
        Arrays.sort(nums);
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
            while( index+1<nums.length && nums[index]==nums[index+1]){
                index++;
            }
            backTrack(index+1, combo);
        }
    }
    @Test
     public void t(){
        int[]nums={1,2,2};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);

    }
}
