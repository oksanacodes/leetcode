package com.example.demo.array.Two_Sum_Sorted_167;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
167. Two Sum II - Input Array Is Sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Time complexity: O(n). Single pass.

Space complexity: O(1). Constant space is used.
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[]result = new int[2];

        int start=0;
        int end = numbers.length-1;
        while(start<end){
            if(numbers[start]+numbers[end]==target){
                result[0]=start+1;
                result[1]=end+1;
                return result;
            }else if(numbers[start]+numbers[end]>target){
                end--;
            }else{
                start++;
            }
        }
        return result;
    }

    @Test
    public void t(){
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(numbers,target);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);

    }
}
