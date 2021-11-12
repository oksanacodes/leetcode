package com.example.demo.stack.Valid_Paranthesis_20;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses https://leetcode.com/problems/valid-parentheses/solution/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * 1. Initialize a stack
 * 2. When you encounter open parantheses, add to the stack
 * 3. When you encounter close paranthesis, pop the element from the stack to see if the pair is a match. If it is not a match, we stop and return false
 * 4. If in the end stack has some elements left, it means we have unmatched paranthesis.
 *
 * Runtime O(n) - traverse string one character at a time
 * Space O(n) - we push n characters to the stack at at time in the worst case scenario
 */
public class Solution {
    public boolean isValid(String s){
        Map<Character, Character> par = new HashMap<>();
        par.put('(', ')');
        par.put('{', '}');
        par.put('[', ']');


        Stack<Character> stack = new Stack<>();
        char[]chars = s.toCharArray();
        for(int i=0;i<chars.length; i++){
            // parse open paranthesis
            if(par.containsKey(chars[i])){
                stack.push(chars[i]);
            }else{
                //next char is a closed paranthesis. Check if its a match
                if(!stack.isEmpty()){
                    char closed = stack.pop();
                    if(chars[i] !=par.get(closed)){
                        return false;
                    }
                }


            }
        }
        return stack.isEmpty();

    }




    @Test
    public void t(){
        String balanced = "{[]}";
        String notBalanced = "([)]";
        Assert.isTrue(isValid(balanced));
        Assert.isTrue(!isValid(notBalanced));

    }


}
