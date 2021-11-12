package com.example.demo.array.TwoSum_1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
public class Solution {


    public int[] twoSum(int[] nums, int target) {
        int[]result = new int[2];
        Map<Integer, Integer> candidates = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(target<nums[i]){ // target is 9, element is 15
                continue;
            }else{
                int difference = target-nums[i];   // 9-7=2
                if(candidates.containsKey(difference)){
                    result[0]=i;
                    result[1]=candidates.get(difference);
                    return result;
                }else{
                    candidates.put(nums[i],i);
                }

            }
        }


        return result;
    }

    @Test
    public void t(){
        int target =9;
        int[]nums = {2,7,11,15};
        int[] result =twoSum(nums, target);
        System.out.println(result);

    }
    /*
    Runtime -O(n) - check all elements of the array. We traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.
    Space - O(n) The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     */
}
