package com.example.demo.stack.ImplementQueueUsingStacks;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {

    /*
    Throught process:
    1. Use 2 stacks: 1) to push elements 2) to pop elements. To recreate queue we need to pop all elements from first stack
    and push them to the second stack to get the elements in the reversed order.


     */

    public class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue(){
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        /*
         Time complexity : O(1). Аppending an element to a stack is an O(1) operation.
         Space complexity : O(n). We need additional memory to store the queue elements
         */
        public void push(int val){
            stack1.push(val);
        }
        /*
        Time complexity : O(n).  When stack s2 is not empty the algorithm has O(1) time complexity. In the worst case scenario when stack s2 is empty,
        the algorithm pops n elements from stack s1 and pushes n elements to s2, where n is the queue size. This gives 2n operations, which is O(n).

        Space complexity : O(1).

         */

        public int pop(){
            if(!stack2.isEmpty()){
                return stack2.pop();
            }
            while(!stack1.isEmpty()){
                int removedElement = stack1.pop();
                stack2.push(removedElement);
            }
            return stack2.pop();
        }

        public int peek(){
            if(!stack2.isEmpty()){
                return stack2.peek();
            }
            while(!stack1.isEmpty()){
                int removedElement = stack1.pop();
                stack2.push(removedElement);
            }
            return stack2.peek();
        }

        /*
        Time complexity : O(1).
        Space complexity : O(1).
         */
        public boolean empty(){
            if(stack2.isEmpty() && stack1.isEmpty()){
                return true;
            }
            return false;
        }

    }


    @Test
    public void t(){
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.print(q.pop() + " " + q.pop() + " " + q.pop());
    }


}
