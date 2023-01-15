package com.example.demo.array.RotateArray;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k){
        if(k> nums.length){
            k=nums.length%k;
        }
        reverse(0,nums.length-1,nums);
        reverse(0,k-1, nums);
        reverse(k, nums.length-1,nums);
    }

    public void reverse(int begin, int end, int[]nums){
        while(begin<end){
            int temp = nums[begin];
            nums[begin]=nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    @Test
    public void t(){
       int[]nums = {1,2,3,4,5,6,7};
       int k=3;
       rotate(nums, k);
    }
    /*
    Runtime Complexity is O(n)*k- linear scan of the array k times
    Space complexity is O(1) to account for constants and pointers
    */
}
