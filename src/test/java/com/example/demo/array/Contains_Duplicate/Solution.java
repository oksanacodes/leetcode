package com.example.demo.array.Contains_Duplicate;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
               return true;
            }else{
                map.put(nums[i],0);
            }
        }
        return false;
    }

    @Test
    public void t(){
        int []nums = {1,2,3,1};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
        assert result;
    }
}
