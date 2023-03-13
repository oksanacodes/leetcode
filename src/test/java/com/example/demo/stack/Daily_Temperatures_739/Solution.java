package com.example.demo.stack.Daily_Temperatures_739;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
 which this is possible, keep answer[i] == 0 instead.

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

RunTime: O(n) - because we do one linear scan of the array. Poping and adding element to the stack takes O(1)
Space: O(n) - size of the stack or size of the array whichever is bigger

 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures){
        int[]result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.add(i);
        }

        return result;
    }

    @Test
    public void t(){
        int[]temperatures = {73,74,75,71,69,72,76,73};
        int[]result = dailyTemperatures(temperatures);
        //Output: [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}
