package com.example.demo.array.Intersection_Of_SortedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    public int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //   int[]nums1 = {1,1,2,2};
        //   int[] nums2 = {2,2};
        int i=0; // read pointer for nums1
        int j=0; // read pointer for nums2
        int k=0; //write pointer for the nums1; first k elements wil be an intersection.
        while(i<nums1.length && j< nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            } else if (nums2[j]<nums1[i]) {
                j++;
            }else{
                nums1[k]=nums1[i];
                k++;
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }

    @Test
    public void t(){
        int[]nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] result = intersect(nums1, nums2);
        System.out.println(result);
    }

}


/*
BigO(nlogn+mlogm), where n and m are the lengths of the arrays.
We sort two arrays independently, and then do a linear scan.
 */

