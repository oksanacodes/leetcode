package com.example.demo.heap.KthLargestElementInAnArray_215;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
/*
215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

You must solve it in O(n) time complexity.


Time: O(K*log(N)) - Converting an array into a Heap takes O(N) time (it isn't actually sorting; it's putting them into an order that allows us to get the maximums,
each in O(logN) time. The main loop iterates up to N−1 times.
This time however, it's doing up to three O(logN) operation each time; two removes, and an optional add
This means that we're doing O(K*logN) operations. So total time complexity is O(N)+ O(K*logN) = O(N)
Space: O(N) - to create a priority queue

 */

public class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int result =0;
        for (int i=0;i<nums.length;i++){
            maxHeap.offer(nums[i]);
        }

        while(!maxHeap.isEmpty() && k>0){
            result = maxHeap.remove();
            k--;
        }
        return result;
    }

    @Test
    public void t(){
        int[]nums = {3,2,1,5,6,4};
        int k = 2;
        int result = findKthLargest(nums,k);
        Assertions.assertEquals(5, result);
    }
}
