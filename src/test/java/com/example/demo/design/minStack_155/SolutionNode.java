package com.example.demo.design.minStack_155;

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
 *
 */

public class SolutionNode {
    Node head;
    int min;

    public SolutionNode(){
        this.min = Integer.MAX_VALUE;
        this.head=null;

    }

    public void push(int val) {
        Node node = new Node();
        node.value = val;
        node.next=head;
        this.head = node;
        this.min = Math.min(val,min);
        node.min = min;

    }

    public void pop(){
        if(head!=null){
            this.head = head.next;
            this.min=head.min;
        }else{
            this.min = Integer.MAX_VALUE;
        }
    }

    public int top(){
        return head.value;
    }

    public int getMin(){
        return head.min;
    }


}




