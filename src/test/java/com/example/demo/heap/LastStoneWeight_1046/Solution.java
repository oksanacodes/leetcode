package com.example.demo.heap.LastStoneWeight_1046;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/last-stone-weight/description/
1046. Last Stone Weight
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

Time: O(N*log(N)) - Converting an array into a Heap takes O(N) time (it isn't actually sorting; it's putting them into an order that allows us to get the maximums,
each in O(logN) time. The main loop iterates up to N−1 times.
This time however, it's doing up to three O(logN) operation each time; two removes, and an optional add
This means that we're doing O(NlogN) operations.
Space: O(N) - to create a priority queue
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            heap.offer(stone);
        }

        while(heap.size()>=2){
            int x = heap.remove();
            int y = heap.remove();
            if(x>y){
                int diff = x-y;
                heap.offer(diff);
            }
        }
        if(heap.size()==1){
            return heap.peek();
        }
        return 0;
    }

    @Test
    public void t(){
        int[]stones = {2,7,4,1,8,1};
        int result = lastStoneWeight(stones);
        Assertions.assertEquals(1,result);
    }
}
