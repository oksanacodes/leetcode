package com.example.demo.linkedList.LRU_Cache_146;

import java.util.HashMap;
import java.util.Map;

class Solution {


    Map<Integer, Node> cache;
    int capacity;

    Node leastRecentlyUsed;
    Node mostRecentlyUsed;

    public Solution(int capacity) {
        this.capacity=capacity;
        this.cache = new HashMap<>();

        this.leastRecentlyUsed = new Node(0,0);
        this.mostRecentlyUsed = new Node(0,0);
        this.leastRecentlyUsed.next= mostRecentlyUsed;
        this.mostRecentlyUsed.prev=leastRecentlyUsed;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node node = new Node(key, value);
        cache.put(key, node);
        insert(cache.get(key));


        if(cache.size()>capacity){
            // remove from the list and delte the LRU from the hashmap
            Node LRU = this.leastRecentlyUsed.next;
            remove(LRU);
            cache.remove(LRU.key);
        }
    }


    // insert next to the mostRecentlyUsed pointer
    public void insert(Node node){
        Node next = mostRecentlyUsed;
        Node prev = mostRecentlyUsed.prev;

        prev.next=node;
        next.prev = node;

        node.next=next;
        node.prev=prev;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next=next;
        next.prev=prev;
    }



    public class Node {

        private int key;
        private int val;

        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
