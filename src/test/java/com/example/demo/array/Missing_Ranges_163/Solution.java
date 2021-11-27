package com.example.demo.array.Missing_Ranges_163;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: ["2","4->49","51->74","76->99"]
 * Explanation: The ranges are:
 * [2,2] --> "2"
 * [4,49] --> "4->49"
 * [51,74] --> "51->74"
 * [76,99] --> "76->99"
 *
 */


public class Solution {

    List<String> missingRanges = new ArrayList<>();

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {


        //1. find missing ranges from lower to nums[0]      prev = 0  current =5  expected "0"-> "4"

        //2. find missing ranges in nums
        //3. find missing ranges from nums[0] to upper.
        //4. Current is the element of the array. However, once we reach the end of the array, current becomes upper limit

        int current=0;
        int previous = lower-1;
        for (int i=0; i<=nums.length; i++){
            if(i==nums.length){
                current = upper+1;
            }else{
                current=nums[i];
            }


            if((current -previous)>1){
                int minR = previous+1;
                int maxR = current-1;
                formatResult(minR, maxR);
            }
            previous=current;

        }

        return missingRanges;

    }

    private void formatResult(int minR, int maxR) {
        StringBuilder sb = new StringBuilder();

        if(maxR==minR){
            sb.append(maxR);
        }else{
            sb.append(minR).append("->").append(maxR);
        }
        missingRanges.add(sb.toString());
    }


    @Test
    public void t(){
        int[]nums={0,1,3,50,75};
        int lower = 0;
        int upper = 99;
        List<String> result = findMissingRanges(nums, lower, upper);
        System.out.println(result);
        Assert.notNull(result);
    }
    /**
     * Runtime O(n).
     *      This is because we are only iterating over the array once, and at each step, we're performing O(1) operations.
     *
     * Space O(1)
     *   The output list has a worst case size of O(N).
     *   This case occurs when we have a missing range between each of the consecutive elements in the input array
     *   (for example, if the input array contains all even numbers between lower and upper).
     *
     *   However, output space that is simply used to return the output (and not to do any processing)
     *   is not counted for the purpose of space complexity analysis. For this reason, the overall space complexity is O(1).
     */


}


