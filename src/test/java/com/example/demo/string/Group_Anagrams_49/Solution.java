package com.example.demo.string.Group_Anagrams_49;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 49. Group Anagrams https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Approach:
 * 1. sort the word by characters .E.g.: eat-> aet, tea-> aet
 * 2. create a map, where key is the sortedString, and values are anagrams. aet-> [eat, tea]
 * 3. iterate through the map and print values of the map.
 *
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String word: strs){
            //1. reverseString
            char[] reversed = word.toCharArray();
            Arrays.sort(reversed);
            String key = String.valueOf(reversed);
            //2. add to map where key is the sorted string, value -> words that form anagrams
            List<String>anagrams = map.getOrDefault(key, new ArrayList<>());
            anagrams.add(word);
            map.put(key, anagrams);


        }
        System.out.println(map);

        map.values().forEach(v-> result.add(v));


        return result;

    }


    @Test
    public void test(){
        String [] str ={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagrams = groupAnagrams(str);
        System.out.println(anagrams);
    }

    /**
     * Runtime is O(n)* O(klogk), where n is the number of words. and k is the number of characters in the word
     * Space O(n*k) to allocate hashmap content - to store n strings where each string has k characters
     */
}
