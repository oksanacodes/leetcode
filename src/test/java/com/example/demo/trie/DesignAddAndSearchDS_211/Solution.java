package com.example.demo.trie.DesignAddAndSearchDS_211;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/*
211. Design Add and Search Words Data Structure
https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
word may contain dots '.' where dots can be matched with any letter.

Video Solution  https://www.youtube.com/watch?v=BTf05gs_8iU

Complexity Analysis:
I. Adding
    - Runtime: O(M) where M is the average length of the key. At each step we either create or
    add node to the trie
    - Space:O(M). In the worst-case newly inserted key doesn't share a prefix with the keys already inserted in the trie.
    We have to add M new nodes, which takes O(M) space.
II. Search:
    - Runtime: Depends wether we are searching for a word with dots.
    If we are searching for the word w/o dots, it will take O(M) where M is the average length of the key.
    At each step we examine a node in the trie
    If we are searching for the word with dots, it will take N*M^26 were N is the number of keys, and M is the length of the key
    - Space: Depends wether we are searching for a word with dots.
    If we are searching for the word w/o dots, then we are using only additional constants to find the word,
    which takes O(1).
    If we are searching for the word with dots, then the space complexity would be equal to the size fo the recursion stack.


 */
public class Solution {

    TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(current.children.containsKey(c)){
                current = current.children.get(c);
            }else{
                TrieNode newNode = new TrieNode();
                current.children.put(c, newNode);
                current = current.children.get(c);
            }
        }
        current.setEndOfWord();
    }

    public boolean search(String word){
        return dfs(word, root);
    }
    public boolean dfs(String word, TrieNode trieNode) {
        TrieNode current = trieNode;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(char ch: current.children.keySet()){
                    if(dfs(word.substring(i+1), current.children.get(ch))){
                        return true;
                    }
                }
                return false;
            }
            else if(current.children.containsKey(c)){
                current = current.children.get(c);
            }else{
                return false;
            }
        }

        return current.isEnd;
    }


    @Test
    public void t(){
        Solution wordDictionary = new Solution();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertFalse(wordDictionary.search("pad")); // return False
        Assertions.assertTrue(wordDictionary.search("bad")); // return True
        Assertions.assertTrue(wordDictionary.search(".ad")); // return True
        Assertions.assertTrue(wordDictionary.search("b..")); // return True
    }

    class TrieNode{
        private Map<Character, TrieNode> children;
        private  boolean isEnd;

        TrieNode(){
            this.children = new HashMap<>();
            this.isEnd =false;
        }

        public boolean isEndOfWord(){
            return this.isEnd;
        }
        public void setEndOfWord(){
            this.isEnd=true;
        }
    }
}
