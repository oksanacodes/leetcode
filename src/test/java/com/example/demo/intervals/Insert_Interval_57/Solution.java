package com.example.demo.intervals.Insert_Interval_57;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
57. Insert Interval
https://leetcode.com/problems/insert-interval/description/
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval: intervals){
            if(newInterval==null){
                result.add(interval);
            }
            else if(interval[0]>newInterval[1]){
                result.add(newInterval);
                result.add(interval);
                newInterval=null;
            }else if(newInterval[0]>interval[1]){
                result.add(interval);
            }else{
                newInterval[0]=Math.min(newInterval[0], interval[0]);
                newInterval[1]=Math.max(newInterval[1], interval[1]);
            }
        }
        if(newInterval!=null){
            result.add(newInterval);
        }
        int[][]finalResult =new int[result.size()][2];
        return result.toArray(finalResult);
    }

    @Test
    public void t(){
        int[][]intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[]newInterval = {4,8};
        int[][] result = insert(intervals, newInterval);
        //Output: [[1,2],[3,10],[12,16]]
        System.out.println(Arrays.stream(result[0]).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(result[1]).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(result[2]).boxed().collect(Collectors.toList()));
    }
}
