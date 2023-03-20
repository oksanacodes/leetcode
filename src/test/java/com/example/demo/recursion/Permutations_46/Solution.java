package com.example.demo.recursion.Permutations_46;

import java.util.ArrayList;
import java.util.List;

/*

46. Permutations  https://leetcode.com/problems/permutations/description/

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Runtime is O(N!*N) where N! is the number of permutations, and N is the number of times you need to traverse the array

space complexity is O(N) is the size of the recursion stack
 */
public class Solution {

    private List<List<Integer>> result;
    private int[]nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        this.result= new ArrayList<>();
        generate(new ArrayList<>());
        return result;
    }

    private void generate(List<Integer> permutation){
        // if we reached the same length its permutation
        if(permutation.size()==nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i=0;i<nums.length;i++){
            // edge case: skip if the
            if(permutation.contains(nums[i])){
                continue;
            }
            // case 1: include element to the list
            permutation.add(nums[i]);
            generate(permutation);

            // case 2: do not include element in the permutation
            permutation.remove(permutation.size()-1);
        }
    }


}
