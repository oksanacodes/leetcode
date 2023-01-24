package com.example.demo.binarySearch.SearchInRotatedSortedArray_33;

import org.junit.jupiter.api.Test;

/**
 33. Search in Rotated Sorted Array
 https://leetcode.com/problems/search-in-rotated-sorted-array/
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 */
public class Solution {

    /*
    Thought process:
    1. Find the rotationIndex - the smallest element in the array
    Time complexity : O(log⁡N)\mathcal{O}(\log{N})O(logN).
    Space complexity : O(1)\mathcal{O}(1)O(1).

     */

    public int search(int[]nums, int target){
        if(nums.length==1 && nums[0]==target){
            return 0;
        }
        if(nums.length==0 && nums[0]!=target){
            return -1;
        }

        //1. Find rotation index . Eg: [7 8 9 1 2 3]. Rotation index is 3 where nums[3]=1
        int rotationIndex = findRotationIndex(nums);
        //2. Now I have two sorted subarrays divided by rotation index [7 8 9] and [1 2 3].
        System.out.println("rotationIndex " + rotationIndex);


        // if target is the smallest element
        if(nums[rotationIndex]==target){
            return rotationIndex;
        }

        // if array is not rotated, search in the entire array
        if (rotationIndex == 0)
            return search(nums,0, nums.length-1,target);
        if (target < nums[0])
            // search in the right side
            return search(nums,rotationIndex, nums.length- 1,target);
        // search in the left side
        return search(nums,0, rotationIndex-1,target);
    }

    public int search(int[]nums, int left, int right, int target) {
    /*
    Binary search
    */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public int findRotationIndex(int[]nums){
        int begin = 0;
        int end = nums.length-1;

        //array is not rotated
        if(nums[begin]<nums[end]){
            return 0;
        }

        while(begin<=end){
            int middle = (end-begin)/2+begin;
            if(nums[middle]>nums[middle+1]){
                return middle+1;
            }else{
                if(nums[middle]<nums[begin]){
                    end=middle-1;
                }else{
                    begin=middle+1;
                }
            }
        }
        return 0;
    }

   @Test
    public void t(){
       int [] nums= {4,5,6,7,0,1,2};
       int target=0;
       int result = search(nums, target);
       assert 4==result;
    }
}
