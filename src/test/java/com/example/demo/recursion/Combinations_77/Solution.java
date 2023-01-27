package com.example.demo.recursion.Combinations_77;


import org.junit.jupiter.api.Test;

import java.util.*;

/*
77. Combinations
https://leetcode.com/problems/combinations/description/
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

SOLUTION:
    Youtube explanation https://www.youtube.com/watch?v=q0s6m7AiM7o&t=188s

 */
public class Solution {
    int n;
    int k;
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k){
        this.n= n;
        this.k = k;
        this.result = new ArrayList<>();

        backtrack(1,new ArrayList<>());
        return result;
    }

    /*
    Thought process:
    1. Iterate through the list from 1 to n
        - add integers to the current combination
        - if the size of the combination is == k, we reached our base case, and can append that combination to our final list
        There is no need to explore other solutions backtrack (int start, List<Integer> combo)
        [2,1] where k=2
        - now we need to backrack, and we can do it by removing the last element in the combo list
        [2]
    Runtime is N* 2^n. Because we are making 2 decisions werether to include the number or not. and n is the height of the tree)
                1       2   3   4
             2 3 4    3 4   4

    Space complexity will be amount of combinations generated
    C(n, r) = n! / (r! . (n-r)!)
    Combination and permutation calculations appear often in daily programming challenges such as HackerRank. Even though we all know how to calculate these values from high school day, this becomes challenging when we are working on really large numbers. We can apply some hacking skills to the traditional formulas and transform these calculations in a simpler form. Let’s do cracking the coding interview!

Combination
Traditional formula of r-combination (or n choose r) is:

C(n, r) = n! / (r! . (n-r)!)

For example, 5 choose 3 will be:
C(5,3 ) = 5! / (3! . (5-3)!) = 5! / (3! . 2!) = 120 / (6 . 2) = 10

     */

    public void backtrack(int start, List<Integer> combo){
        if(combo.size()==k){
            result.add(new ArrayList<>(combo));
            // we cant do here result.add(combo) because it will override added value.
            return;
        }
        for(int i=start;i<=n;i++){
            combo.add(i);
            backtrack(i++,combo);
            combo.remove(combo.size()-1);
        }
    }



    @Test
    public void test(){
        int n=4;
        int k=2;
        List<List<Integer>> result = combine(n,k);

        System.out.println(result);
    }



    @Test
    public void t(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> element = Arrays.asList(1,2,3);
        List<Integer> element1 = Arrays.asList(1,2,3);
        result.add(new ArrayList<>(element));
        System.out.println(result);

        List<List<Integer>> result1 = new ArrayList<>();
        //List<Integer> element = Arrays.asList(1,2,3);
        result1.add(element);
        result1.add(element1);
        System.out.println(result1);
        element1=Arrays.asList(5,6,7);
        System.out.println(result1);

    }
}
