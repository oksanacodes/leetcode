package com.example.demo.array.Max_SubArray_53;

import org.junit.jupiter.api.Test;

public class Solution {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     */

    /*
    1. Brute Force solution. Iterate through all possible subarrays and calculate subarraySum. If subarraySum>GlobalMax, than update globalMax
    RunTime is O(n^2), using 2 nested loops.Each loop iterates through nums of lengh n.
    Space time is O(1) we are using only two variables - localSum and globalSum
     */

    public int maxSubArrayBruteForce(int[] nums){

        int globalMax =0;


        for (int i=0;i<nums.length;i++){
            int localSumOfSubarray=0;
            for (int j=i;j<nums.length;j++){
                localSumOfSubarray=localSumOfSubarray+nums[j];
                globalMax=Math.max(localSumOfSubarray, globalMax);
            }
        }

        return globalMax;

    }

    @Test
    public  void tBruteForce(){
        int[]nums ={2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArrayBruteForce(nums);
        System.out.println(result);

    }
    /*
    2. Solution 2. DP approach. If sum of subArray> nums[i], restart.
     Runtime - O(n) | Space - O(1)

     */

    public int maxSubArrayDP(int[] nums){
        int globalMax =nums[0];
        int SubArraySum = nums[0];
        for (int i=1;i<nums.length;i++){
            SubArraySum = SubArraySum+nums[i];
            SubArraySum = Math.max(SubArraySum, nums[i]);// if element is bigger than sum of the subarray, restart the index of the subarray. Start counting from begining
            globalMax = Math.max(globalMax, SubArraySum);

        }
        return globalMax;
    }


    @Test
    public  void tDP(){
        int[]nums ={2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArrayDP(nums);
        System.out.println(result);

    }

    // The begining of the maxSubarray is the position of the element that is bigger than subsum. happens when we do restart
    // The end of the maxSubarray is the position of the element that causes the last update of maxGlobal

    public int maxSubArraIndeces(int[] nums){
        int[] indexes = new int[2]; // to store indices where first element is the begining of the subarray, and second - end of the subarray
        int globalMax =nums[0];
        int SubArraySum = nums[0];
        for (int i=1;i<nums.length;i++){
            SubArraySum = SubArraySum+nums[i];
            if(nums[i]>SubArraySum){
                indexes[0]=i;
                SubArraySum=nums[i];
            }

           // if element is bigger than sum of the subarray, restart the index of the subarray. Start counting from begining
           // globalMax = Math.max(globalMax, SubArraySum);
            if (globalMax <SubArraySum) {
                globalMax=SubArraySum;
                indexes[1]=i;
            }

        }
        System.out.println("Begining at "+indexes[0]+"and ends at "+indexes[1]);
        return globalMax;
    }

    @Test
    public  void tIndexes(){
        int[]nums ={-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArraIndeces(nums);
        System.out.println(result);

    }



}
