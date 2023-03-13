package com.example.demo.array.Three_Sum_15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 3Sum
https://leetcode.com/problems/3sum/

Time Complexity: O(N^2)
Space: O(N)

 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length;i++){
            // if the number is positive, there is no combination that would lead to 0
            if(nums[i]>0){
                break;
                //[2,2,2,2 3,4] if number is repeated, skip
            }else if(i==0|| nums[i]!=nums[i-1]){
                search(i, nums, result);
            }
        }
        return result;
    }

    public void search(int targetIndex, int[] nums,List<List<Integer>>  result ){
        int start = targetIndex+1;
        int end = nums.length-1;
        while(start<end){
            int sum = nums[targetIndex]+nums[start]+nums[end];
            if(sum>0){
                end--;
            }else if(sum<0){
                start++;
            }else{
                List<Integer> res = Arrays.asList(nums[targetIndex], nums[start], nums[end]);
                result.add(res);
                start++;
                end--;
                while(start<end && nums[start]==nums[start-1]){
                    start++;
                }
            }
        }
    }

    @Test
    public void t(){
        int[]nums = {-1,0,1,2,-1,-4};
        //Output: [[-1,-1,2],[-1,0,1]]
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
