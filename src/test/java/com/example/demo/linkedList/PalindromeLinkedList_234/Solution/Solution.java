package com.example.demo.linkedList.PalindromeLinkedList_234.Solution;

import com.example.demo.linkedList.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 234. Palindrome Linked List  https://leetcode.com/problems/palindrome-linked-list/
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 *
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ArrayList<Integer> l = new ArrayList<>();
        while (current != null) {
            int val = current.val;
            l.add(val);
            current = current.next;

        }


        int start = 0;
        int end = l.size() - 1;
        while (start <= end) {
            if (l.get(start) != l.get(end - start)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    @Test
    public void t() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);


        //l1
        a.next = b;
        b.next = c;
        c.next = d;


        boolean result = isPalindrome(a);
        System.out.println(result);
    }
}

    /**
     * Runtime - O(n) : 1) traverse linked list and add values to the arraylist, 2) iterate arrayList to check if its a palindrome
     * We need to check at least n/2 values to make a decision if its a palindrome. Runtime to access a value from the list is O(1)
     * Space - O(n). 1) create arrayList that has n values; 2) pointers that occupie O(1) space
     * */

