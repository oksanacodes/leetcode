package com.example.demo.array.Remove_Duplicates_FromSortedArray;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int u = 0; // points to unique elements in the array
        for(int i=1; i<nums.length; i++){
            if(nums[u]== nums[i]){
                continue;
            }else{
                // we found a unique element, perform swap
                int temp = nums[u+1];
                //[0,0,1,1,2]
                //  u   i
                nums[u+1]=nums[i];
                nums[i]=temp;
                //[0,1,0,1,2]
                //    u i
                u++;
                //[0,1,2,1,0]
            }
        }
        return u+1;
    }
    /*
    Time Complexity: O(N), since we only have 2 pointers, and both the pointers will traverse the array at most once.

    Space Complexity: O(1), since we are not using any extra space.
     */
}
