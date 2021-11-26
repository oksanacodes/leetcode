package com.example.demo.string.LongestCommonPrefix_14;

public class TrieNode {
    public TrieNode[]children;
    public boolean isEndWord;
    public int countLinks;

    public TrieNode(){
        this.children=new TrieNode[26];
        this.isEndWord = false;
        this.countLinks=0;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isEndWord() {
        return isEndWord;
    }
    public int getCountLinks(){
        return countLinks;
    }
}
