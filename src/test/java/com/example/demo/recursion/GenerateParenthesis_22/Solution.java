package com.example.demo.recursion.GenerateParenthesis_22;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {

    /*

Time Complexity : O(N* 2^(2N)) For each of 2^(2N) sequences, we need to create and validate the sequence, which takes O(n) work.
Space Complexity : O(N* 2^(2N)). Because every single sequence can be valid.

    Thought Process is

    1. generate different combination of parentheses using recursion. The base case is when length of generated string is equal to 2*N
    2. use the stack to confirm that the generated string has balanced parenthesis
     */

    public List<String> generateParenthesis(int n) {
        String input = "";
        Set<String> result = new HashSet();
        generateCombinations(n,input, result);
        return new ArrayList(result);
    }

    public void generateCombinations(int k, String input,Set<String> result ){
        if(input.length()==2*k){
            if(isCombinationValid(input)){
                result.add(input);
            }
            return;
        }
        generateCombinations(k,input.concat(")"),result);
        generateCombinations(k,input.concat("("),result);
    }
    public boolean isCombinationValid(String input){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++){
            char c= input.charAt(i);
            //1. -'('
            if(c=='('){
                stack.push(c);
            }else{
                //2. - ')'
                if(!stack.isEmpty() && stack.peek()=='(' && c==')'){
                    stack.pop();
                }else{
                    return false;
                }
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    @Test
    public void t(){
        int n=3;
        List<String> result = generateParenthesis(3);
        assert result.size()==5;
        System.out.println(result);
    }
}
