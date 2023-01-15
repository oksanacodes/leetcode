package com.example.demo.array.Product_OfArray_ExceptSelf;

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

        for (int i=0;i<end; i++){
            int product =1;
            //calculate product to the left
            for(int j=0; j<i;j++){
                product=product* nums[j];
            }
            //calculate product to the right
            for(int k=i+1; k<end; k++){
                product= product* nums[k];
            }
            //update arrray
            result[i]=product;
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
}
