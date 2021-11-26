package com.example.demo.string.LongestCommonPrefix_14;

public class Trie {
    private TrieNode root;
    private int totalWords;

    public Trie(){
        this.root = new TrieNode();
        this.totalWords=0;
    }

    public int getCurrentIndex(char c){
        return c-'a';
    }

    /**
     * You are trying to insert "hello" in a trie. Determine first characer which is h. Find the index of h in a trie.
     * If h is not in the trie: 1) create a node; 2) link root to the child at index of h; 3) move currentNode pointer from root to the child at index h
     * If h is in the trie-> go level down -
     *
     * @param word
     */

    public void insert(String word){
        TrieNode currentNode = this.root;
        for (int i=0;i<word.toCharArray().length;i++){
            char c = word.toCharArray()[i];
            int index = getCurrentIndex(c);
            if(currentNode.children[index]==null){
                TrieNode t = new TrieNode();
                currentNode.children[index]=t;
                currentNode.countLinks++;
                currentNode = currentNode.children[index];
            }else{
                currentNode.countLinks++;
                currentNode=currentNode.children[index];
            }


        }
        currentNode.isEndWord=true;
        totalWords++;
    }
    public String commonPrefix(String word){
        String prefix="";
        TrieNode currentNode=this.root;
        for(int i=0;i<word.toCharArray().length;i++){
            char c = word.toCharArray()[i];
            int index = getCurrentIndex(c);
            if(currentNode.children[index]!=null && currentNode.children[index].countLinks==totalWords){
                prefix=prefix+c;
                currentNode=currentNode.children[index];
            }else{
                return prefix;
            }

        }

        return prefix;
    }
}
