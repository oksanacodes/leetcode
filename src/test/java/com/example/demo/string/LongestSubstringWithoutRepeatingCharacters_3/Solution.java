package com.example.demo.string.LongestSubstringWithoutRepeatingCharacters_3;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 *
 * Thought process:
 * 1. convert string into char array
 * 2. define pointers to keep the track of the begining and end of the substring
 * 3. define map to keep track of unique elements, where key is the character and value - index of that character in the string
 * 4. if the character was alredy added to the map (occurred at least twice), we move start pointer to the next character and consider it as a new substring(e.g.vdvf , new substring will be dvf)
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int end=0;
        int start=0;
        int global = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            char c = arr[i];
            if(map.containsKey(c)){
                int duplicateIndex=map.get(c)+1;
                start=Math.max(start,duplicateIndex);
            }
                map.put(c,i);

            int strLen = end-start+1;
            global=Math.max(global, strLen);
            end++;
        }
        return global;
    }

    @Test
    public void test(){
        String s = "abcabcbb";
        int returnValue = lengthOfLongestSubstring(s);
        System.out.println(returnValue);
    }

    @Test
    public void test2(){
        String s2= "pwwkew";
        int returnValue2 = lengthOfLongestSubstring(s2);
        System.out.println(returnValue2);
    }

    @Test
    public void test3(){
        String s2= "dvdf";
        int returnValue2 = lengthOfLongestSubstring(s2);
        System.out.println(returnValue2);
    }

    @Test
    public void test4(){
        String s2= "tmmzuxt";
        int returnValue2 = lengthOfLongestSubstring(s2);
        System.out.println(returnValue2);
    }
    @Test
    public void test5(){
        String s="abba";
        int returnValue = lengthOfLongestSubstring(s);
        System.out.println(returnValue);
    }
}
