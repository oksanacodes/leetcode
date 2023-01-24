package com.example.demo.queue.ImplementStackUsingQueues225;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/*
    Push - O(1)
    Pop - O(n)

    Thought process:
    1) use q1 to push elements into the queue. Every last element added to the queue is also the head fo the stack.
    2) use q2 to pop elements from the queue.The 2nd to last element on that queueue will be a new head of the stack
 */
public class Solution {
    class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;
        int top;
        public MyStack() {
            q1= new LinkedList<>();
            q2= new LinkedList<>();
            top=-1;
        }
        /*
        new element is added to the end of the queue and is the head of the stack
        Runtime O(1) - Queue is implemented as linked list and add operation has O(1)O(1)O(1) time complexity.
        Space O(1)
         */
        public void push(int x) {
            q1.offer(x);
            top=x;
        }

        /*
        Time complexity : O(n). The algorithm dequeues n elements from q1 and enqueues n−1 elements to q2, where n is the stack size.
        This gives 2n−1 operations.
        Space complexity : O(1)
         */
        public int pop() {
            while(q1.size()>1){
                top = q1.remove();
                q2.offer(top);
            }
            int popped =q1.remove();
            Queue<Integer> temp = q1;
            q1=q2;
            q2=temp;
            return popped;
        }
        public int top() {
            if(q1.size()==1){
                return q1.peek();
            }
            return top;
        }

        public boolean empty() {
            if(q1.isEmpty() && q2.isEmpty()){
                return true;
            }
            return false;
        }


    }


    @Test
    public void t(){
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

}
