package com.example.demo.array.Encode_and_Decode_Strings_274;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
271. Encode and Decode Strings  https://leetcode.com/problems/encode-and-decode-strings/description/
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.


youtube solution is https://www.youtube.com/watch?v=B1k_sxOSgv8

Thought process encode using 1)length of the word ; 2) delimiter '#' to show the begining of the word

Run: O(N) where N is the size of the List of given Strings
Memory: O(1) for encode to keep the output, since the output is one string.
O(N) for decode keep the output, since the output is an array of strings.

 */
public class Solution {

    // Encodes a list of strings to a single string. => "5#Hello"
    public String encode(List<String> strs) {
        if(strs.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            sb.append(length).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s){
        List<String> result = new ArrayList<>();
        int i=0; // pointer to the begining of the word
        int j=0; // pointer to the number - length of the word
        while(i<s.length()){
            j=i;
            while(s.charAt(j)!='#'){
                j++;
            }
            // j points to '#' in  "5#Hello"
            int length = Integer.valueOf(s.substring(i,j));
            String word = s.substring(j+1, j+1+length);
            result.add(word);
            i= j+1+length;
        }
        return result;
    }


    @Test
    public void t(){
        List<String>dummy_input = Arrays.asList("Hello","World");
        Solution solution = new Solution();
        String encodedString = solution.encode(dummy_input);
        List<String> decode = solution.decode(encodedString);
        //Output: ["Hello","World"]
        System.out.println(decode);
    }


}
