package com.example.demo.array.Longest_Consecutive_Sequence_128;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/*
128. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.





 */
public class Solution {

    /*
    Thought process:
    1) Create a Set
    2) Find the begining of the sequence
    Runtime: O(n) linear scan of nums
    Space: O(n) - creating set of size N
     */
    public int longestConsecutive(int[] nums) {
        int result =1;
        int count=0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        for(int num:nums){
            if(!set.contains(num-1)){
                count=1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
            }
            result = Math.max(result,count);
        }
        return result;
    }



    @Test
    public void t(){
      int[] nums = {100,4,200,1,3,2};
       // Output: 4
       // Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
        int result = longestConsecutive(nums);
        Assertions.assertEquals(4, result);
    }


}
