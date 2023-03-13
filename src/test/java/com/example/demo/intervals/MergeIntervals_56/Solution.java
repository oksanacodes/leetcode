package com.example.demo.intervals.MergeIntervals_56;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
56. Merge Intervals
https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the non-overlapping
intervals that cover all the intervals in the input.

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].



Thought process:
1) Sort the array
2) Find if there is overlap if(a[1]>=b[0])
3) if there is an overlap replace the last indices with the max value between last indices of those intervals
4) if there is no overlap, add it to the list

Runtime: O(NlogN) due to sorting
Space: O(N) - in the worse case scenario if there are no overlaps to create a merged list

 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();


        for(int[] interval: intervals){
            int size = merged.size();
            if(size!=0){
                int[] lastElement = merged.get(size-1);
                // case 1: no overlap [2,3] and [4,5]
                if(lastElement[1]<interval[0]){
                    merged.add(interval);
                }else{
                    //case 2: overlap [2,5] and [4,6] => [2,6]
                    merged.get(size-1)[1]=Math.max(merged.get(size-1)[1], interval[1]);
                }
            }else{
                merged.add(interval);
            }
        }


        int [][]result = new int[merged.size()][2];
        int i=0;
        for(int[]interval: merged){
            result[i]=interval;
            i++;
        }
        return result;
    }

    @Test
    public void t(){
        int[][]intervals ={{1,3},{2,6},{8,10},{15,18}};
        int [][] result = merge(intervals);
        //Output [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.stream(result[0]).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(result[1]).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(result[2]).boxed().collect(Collectors.toList()));
    }


}
