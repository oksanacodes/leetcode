package com.example.demo.string.PalindromePermutation_266;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 266. Palindrome Permutation
 * Given a string s, return true if a permutation of the string could form a palindrome.
 *
 * Input: s = "code"
 * Output: false
 *
 *Input: s = "aab"
 * Output: true
 *
 * 1. Create a map where key is the character and value is the count of that character in string
 * 2. The palindrome can have even number of characters - > every count of characters will be divisible by 2 e.g."abba"
 * The palindrome can have an odd number of characters -> all counts but one will be divisible by 2, eg. aba
 * 3. If the sum of counts that are not divisible by 2 is >1 -> palindrome is not possible
 */
public class Solution {

    public boolean canPermutePalindrome(String s) {
        int sum=0;
        char[] characters = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<characters.length; i++){
            int value = map.getOrDefault(characters[i],0);
            map.put(characters[i], value+1);
        }

        for (Integer value : map.values()) {
            if(value %2 !=0){
                sum++;
            }
        }
        return sum<=1;

    }

    @Test
    public void t(){
        boolean returnValue = canPermutePalindrome("code");
        System.out.println(returnValue);
    }
    /**
     * Runtime - O(n)  We traverse over the given string  with n characters once. We also traverse over the map which can grow up to a size of n in case all characters in string are distinct.
     * Space - O(n). The map can grow up to a maximum number of all distinct elements which can be n in the worse case scenario.
     */
}
