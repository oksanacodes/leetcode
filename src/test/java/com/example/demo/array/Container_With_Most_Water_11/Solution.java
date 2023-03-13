package com.example.demo.array.Container_With_Most_Water_11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/*
11. Container With Most Water https://leetcode.com/problems/container-with-most-water/description/

Time complexity: O(n). Single pass.

Space complexity: O(1). Constant space is used.
 */
public class Solution {

    public int maxArea(int[] height) {
        int maxArea=0;
        int l=0;
        int r= height.length-1;

        while(l<r){
            int width = r-l;
            int length= Math.min(height[l], height[r]);
            int area = width* length;
            maxArea = Math.max(area,maxArea);
            if(height[l]<height[r]){
                l++;
            }else if(height[r]<height[l]){
                r--;
            }else{
                r--;
            }
        }

        return maxArea;
    }

    @Test
    public void t(){
       int[] height = {1,8,6,2,5,4,8,3,7};
       int result = maxArea(height);
        Assertions.assertEquals(49, result);
    }
}
