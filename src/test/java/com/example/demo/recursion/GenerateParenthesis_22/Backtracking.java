package com.example.demo.recursion.GenerateParenthesis_22;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Backtracking {

    /*
     For backtracking its important to eliminate candidates that we know will not lead to the desired solution.
     For example we know that following combinations are not good candidates and its not worth exploring them:
     ((((((
     (((())
     ()()((
     if the count of open and close paranthesis is not the same, we know that we wil not be able to form a balanced paranthesis.
     */
    public List<String> generateParenthesis(int n) {
        String input = "";
        List<String> result= new ArrayList<>();
        generateCombinations(input,n, 0,0,result);
        return result;
    }

    public  void generateCombinations(String input, int n,int closeCount, int openCount, List<String> result){
        if(openCount>n || closeCount>n){
            return;
        }
        if(closeCount==n && openCount==n){
            if(isCombinationValid(input)){
                result.add(input);
            }
            return;
        }
        generateCombinations(input.concat("("), n,closeCount, openCount+1, result);
        generateCombinations(input.concat(")"), n,closeCount+1, openCount, result);
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

        System.out.println(result);
        assert result.size()==5;
    }
}
