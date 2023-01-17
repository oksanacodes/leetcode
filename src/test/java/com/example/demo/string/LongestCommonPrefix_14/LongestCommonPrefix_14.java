package com.example.demo.string.LongestCommonPrefix_14;

import org.junit.jupiter.api.Test;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefix_14 {


    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for(String word: strs){
            trie.insert(word);
        }
        String prefix = trie.commonPrefix(strs[0]);



        return prefix;

    }

    @Test
    public void test(){
        String []strs = {"flower","flow","flight"};
        String returnValue = longestCommonPrefix(strs);
        System.out.println(returnValue);

    }

    /**
     * Rumtime is O(n*m), where n is the number of words in the array. and m is the longest word in the Trie (26 nodes)
     * SpaceTime is
     *
     */


    /*
        RumTime is O(n*m), where n is the number of words in the array and n is the number of all characters in the array.
        SpaceTime is O(1);
     */
    @Test
    public void test2(){
        String []strs = {"flower","flow","flight"};
        String returnValue = longestCommonPrefixIterative(strs);
        System.out.println(returnValue);
    }
    public String longestCommonPrefixIterative(String[]strings){
        String longestCommonPrefix = "";
        if(strings==null || strings.length ==0){
            return longestCommonPrefix;
        }
        String firstWord = strings[0];// firstWord = "flower";
        int index = 0;


        for(char c: firstWord.toCharArray()){
            for (int i=1; i<strings.length;i++){
                if(strings[i].length()<index || strings[i].charAt(index)!=c){
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix +=c;
            index++;
        }
        return longestCommonPrefix;
    }
}
