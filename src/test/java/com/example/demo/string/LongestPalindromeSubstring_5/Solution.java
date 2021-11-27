package com.example.demo.string.LongestPalindromeSubstring_5;

import org.junit.jupiter.api.Test;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * https://github.com/Semaserg/LeetCodeProblems/blob/master/string/LongestPalindromicSubstring_5/Solution.java
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * 1. Expand around the center of the palindrome
 * 2. If the palindrom has odd number e.g. "aba" the center of expansion is between 1 and 1
 * If the palindrom consists of even number e.g. abba the center of expansion is between 1 and 2
 * 3. Check if palindrome is valid by comparing whether char at i+1 == char at i-1
 *
 */
public class Solution {
    int maxStart=0;
    int maxEnd=0;

    public String longestPalindrome(String s) {

        for(int i=1; i<s.length();i++){
            expand(s,i-1,i); // for palindromes with even numbers like abba , no char is in the middle
            expand(s,i-1,i+1); // for palindrome with odd numbers like aba, center is b at index =1, char is in the middle
        }
        System.out.println(maxStart);
        System.out.println(maxEnd);
        return s.substring(maxStart,maxEnd+1);
    }

    private void expand(String s, int start, int end) {
        while (start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            if((maxEnd-maxStart)<(end-start)){
                maxStart=start;
                maxEnd=end;
            }
            start--;
            end++;
        }

    }

    @Test
    public void tEven(){
        String s = "abbacde";
        String returnValue = longestPalindrome(s);
        System.out.println(returnValue);
    }

    @Test
    public void tOdd(){
        String s = "abcdeaba";
        String returnValue = longestPalindrome(s);
        System.out.println(returnValue);
    }
    @Test
    public void t(){
        String s = "cbbd";
        String returnValue = longestPalindrome(s);
        System.out.println(returnValue);
    }

    @Test
    public void t1(){
        String s = "bb";
        String returnValue = longestPalindrome(s);
        System.out.println(returnValue);
    }


}
