package com.example.demo.linkedList.RemoveNthNodeFromEndofList;

import com.example.demo.linkedList.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution {
    /*
    Time: O(n) - linkedList was traversed only once;
    Space: O(1) - no additioal DS was created, used only pointers that take constant space;


    1. Declare pointers fast and slow that will be used to raverse linkedList. Make sure that
    the distance between them is n.

    2. Use dummy head to accomodate the case where there is only 1 element i the list, and that
    element has to be removed. Dont forget to return dummy.next in the end

    3. slow.next  is the element that we want to remove. Do relinking by pointing slow.next = slow.next.next
     */

    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode fast = dummy;
        ListNode slow= dummy;

        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast!=null && fast.next!=null){
            fast=fast.next;
            slow= slow.next;
        }
        slow.next = slow.next.next;
        return  dummy.next;
    }

    @Test
    public void t() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        //l1
        a.next = b;
        b.next = c;
        c.next = d;
        d.next=e;

        //Output: [1,2,3,5],  4 was removed

        ListNode result = removeNthFromEnd(a,2);
        System.out.println(result);
    }
}
