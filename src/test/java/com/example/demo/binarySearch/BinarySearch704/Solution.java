package com.example.demo.binarySearch.BinarySearch704;

import org.junit.jupiter.api.Test;

public class Solution {

    /*
    Mid Calculation. => int mid = (end-begin)/2+begin
    Because left + right may overflow. Which then means you get a result that is less than left. Or far into the negative if you are using signed integers.
    So instead  take the distance between left and right and add half of that to left. This is only a single extra operation to make the algorithm more robust.

     Time Complexity is O(logN) - nums is divided in half each time and it takes logarithmic time to reach this break condition.;
     Space Complexity is O(1) - introduced variables to save pointers such as begin, end, middle
     */

    public int binarySearch(int[]nums,int target){
        int begin = 0;
        int end= nums.length-1;

        while(begin<=end){
            int middle = (end-begin)/2+begin;

            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                end=middle-1;
            }else if(nums[middle]<target){
                begin=begin+1;
            }
        }
        return -1;
    }
    @Test
    public void t1(){
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;
        int result = binarySearch(nums, target);
        assert result==4;
    }
    @Test
    public void t2(){
        int [] nums = {2,5};
        int target = 2;
        int result = binarySearch(nums, target);
        assert result==0;
    }
}
