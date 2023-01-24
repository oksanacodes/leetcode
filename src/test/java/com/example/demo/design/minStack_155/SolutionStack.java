package com.example.demo.design.minStack_155;

import com.example.demo.linkedList.MergeTwoSortedLists_21.Solution;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
   155. Min Stack  https://leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the Solution class:
 *
 * Solution() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * Solution
 * https://leetcode.com/problems/min-stack/discuss/1028410/100-fast-Java-linked-list-solution-O(1)
 *
 * Time complexity O(1)
 * Space complexity O(n)
 *
 * Thought process:
 * 1. Use stack DS, where element of the stack is the arrary where 0 index - is the valu that gets pushed onto stack
 * and 1 index - is the min for that stackTrace
 */

public class SolutionStack {

    Stack<int[]> stack;

    public SolutionStack(){
        stack= new Stack<>();
    }

    public void push(int val) {
        int[]pair = new int[2];
        pair[0] = val;
        if(stack.isEmpty()){
            pair[1]=val;
        }else{
            int currentMin = stack.peek()[1];
            pair[1]= Math.min(currentMin, val);
        }
        stack.push(pair);
    }

    public void pop(){
        stack.pop();
    }

    public int top(){
        return stack.peek()[0];
    }

    public int getMin(){
        return stack.peek()[1];
    }



    @Test
    public void t(){
        SolutionStack stack = new SolutionStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.print(stack.getMin());
        stack.pop();
        stack.top();
        System.out.print(stack.getMin());
    }
}




