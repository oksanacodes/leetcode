package com.example.demo.recursion.Letter_Combinations_of_Phone_Number_17;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]




Runtime: O(4^n)*N, where 4^n is the number of phone combinations and N is the number of time you need to traverse an array
Regarding 4^n - one digit is represented by 3 OR 4 letters, e.g. 9 "wxyz". It meants int the worst case scenario, there are
4^N options of phone numbers. In our case "23" has 9 permutations, becuase 3^2 = 9because "2" and "3" both are represented by 3 characters


Space: O(n) - recursion stack


 */
public class Solution {
    String digits;
    Map<Character, String> digitToChar = generateMap();

    private Map<Character, String> generateMap() {
        Map<Character, String> map =new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9',"wxyz");
        return map;
    }
    List<String> output;

    public List<String> letterCombinations(String digits) {
        this.digits=digits;
        this.output=new ArrayList<>();
        if(digits.length()==0){
            return output;
        }
        backtrack(0,"");
        return output;
    }

    private void backtrack(int i, String temp){
        if(temp.length()==digits.length()){
            output.add(temp);
            return;
        }

        //digits.charAt(0) = "2" but digitToChar.get(digits.charAt(0)) = "abc"

        String options= digitToChar.get(digits.charAt(i));

        for(Character c:options.toCharArray()){
            backtrack(i+1, temp+c);
        }
    }

    @Test
    public void t(){
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
    }


}
