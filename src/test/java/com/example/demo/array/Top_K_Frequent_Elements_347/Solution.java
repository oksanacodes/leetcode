package com.example.demo.array.Top_K_Frequent_Elements_347;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Time: 1) To create map - O(n); 2) To add k elements to the heap for all N keys in the map - O(N*logK);
3) To remove k elements from the heap  - O(K*logK). Total is O(N*logK)
Space: 1) To create map - O(n); 2) The size of the heap - O(K); Total is O(N);

 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k){
        //1. Create a map where key is the element of the array and value is its occurrence
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        //2. min heap initialization
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[]a, int[]b)->a[1]-b[1]);

        // maintain the heap's size at k and keep removing the smallest element from the heap until k largest element left
        for(Integer key: map.keySet()){
            int[]element = {key, map.get(key)};
            queue.add(element);
            if(queue.size()>k){
                queue.poll();
            }
        }

        int[]result = new int[k];

        int i=0;
        while(!queue.isEmpty() && k>0){
            result[i++] = queue.poll()[0];
            k--;
        }
        return result;

    }


    @Test
    public void t(){
        int[]nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequent(nums,k);
        //Output: [1,2]
        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}
