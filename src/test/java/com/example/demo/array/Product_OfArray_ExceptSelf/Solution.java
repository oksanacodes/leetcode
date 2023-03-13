package com.example.demo.array.Product_OfArray_ExceptSelf;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    /**
     *
     * Naive approch
     * Time Complexity is O(n^2) cause we have 2 for loops. We calculate product of all elements to the right, then to the left. Update the element of the array
     * Space Complexity is O(n) cause we need to create a space for an array with n elements
     */
    public int[] productExceptSelf(int[] nums) {
        int end = nums.length;
        int[]result = new int[end];

        int[]prefix=new int[end];

        //calculate product on the left
        prefix[0] =1;
        for(int i=1;i<end;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        //calculate product on the right
        int[]suffix = new int[end];
        suffix[end-1]=1;
        for(int i=end-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
        }

        for(int j=0;j<end;j++){
            result[j]=suffix[j]*prefix[j];
        }

        return result;
    }

    // Great youtube explanation https://www.youtube.com/watch?v=15WzzP_o4nQ
 /*
   To reduce time complexity to the linear time, precompute suffixes and prefixes in advance
   Recursive formula  for suffix is Suffix[i]=Suffix[i+1]*nums[i+1]
   Recursive formula  for postfix is Prefix[i]=Prefix[i-1]*nums[i-1]
  */

    public int[] productExceptSelf_Linear(int[] nums){
        int size = nums.length;
        int[]result = new int[size];


        // precompute prefix
        int []prefix = new int[size];
        prefix[0]=1;
        for (int i=1;i<size;i++){
            prefix[i]= prefix[i-1]*nums[i-1];
        }

        //precompute suffix
        int []suffix = new int[size];
        suffix[size-1]=1;
        for (int j=size-2;j>=0; j--){
            suffix[j]= suffix[j+1]*nums[j+1];
        }

        for(int i=0;i<size;i++){
            result[i]=suffix[i]*prefix[i];
        }

        return result;
    }

    @Test
    public void t(){
        int[]nums = {1,2,3,4};
        //Output: [24,12,8,6]
        int[]result = productExceptSelf(nums);

        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));

    }
}
