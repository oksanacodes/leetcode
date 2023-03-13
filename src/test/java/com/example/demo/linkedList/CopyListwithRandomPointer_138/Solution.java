package com.example.demo.linkedList.CopyListwithRandomPointer_138;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*
    1. First Scan. Create a map to keep track of old-> copy. No linking yet.
    2. Second scan. Do the linking
    Runtime: O(n)
    Space: O (n) - allocated new DS - map
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr= head;
        while(curr!=null){
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr= curr.next;
        }

        curr=head;

        while(curr!=null){
            Node copy = map.get(curr);
            copy.random = map.get(curr.random);
            copy.next=map.get(curr.next);
            curr= curr.next;
        }

        return map.get(head);
    }
}
