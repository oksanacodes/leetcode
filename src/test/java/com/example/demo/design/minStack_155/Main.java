package com.example.demo.design.minStack_155;

public class Main {
    public static void main(String[] args) {
        SolutionNode stack = new SolutionNode();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.print(stack.getMin());
        stack.pop();
        stack.top();
        System.out.print(stack.getMin());
    }
}
