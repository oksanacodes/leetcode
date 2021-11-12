package com.example.demo.stack.Generate_Parenthesis_22;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22. Generate Parentheses https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * 1. Generate all possible combinations using recursion by appending a bracket to the empty string O(2^n)
 * 2. Use stack to check whehter paranthesis are balanced. If parantheses are balanced, add formatted string to the list
 * O(n)
 */
public class Generate_Parenthesis_22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        n=n*2;

        recursive(""+"(", n-1, result);
        recursive(""+")", n-1,result);

        return result;

    }

    private void recursive(String s, int i, List<String> result) {
        if(i==0) {
            if(isValid(s)){
            result.add(s);
            }
        return;
        }
        recursive(s+"(", i-1, result);
        recursive(s+")", i-1,result);
    }
    private  boolean isValid(String s){
        char[]chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(Character character: chars)
        {
            if(character =='('){
                stack.push(character);
            }else{
                if (!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
     }

    @Test
     public void t(){
        List<String> l = new ArrayList<>();
        l.add("((()))");
        l.add("(()())");
        l.add("(())()");
        l.add("()(())");
        l.add("()()()");
        List<String> result = generateParenthesis(3);
        System.out.println(result);

    }
}
