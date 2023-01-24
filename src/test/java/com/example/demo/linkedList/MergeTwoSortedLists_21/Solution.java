package com.example.demo.linkedList.MergeTwoSortedLists_21;

import com.example.demo.linkedList.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class Solution {


    /*
    1. Create the dummy head of the list that will be returned
    2. User prev ListNode that helps to step through the LinkedList.
    3. After loop terminates we know that either l1 or l2 are null. We are gonna link our final list with the non-null list

     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode pseudohead = new ListNode(0);
        ListNode current = pseudohead;


        while(l1 !=null && l2 !=null){
            if(l1.val>=l2.val){
                current.next = l2;
                l2=l2.next;
            }else{
                current.next = l1;
                l1=l1.next;
            }
            current=current.next;
        }
        if(l1!=null){
            current.next = l1;
        }
        if(l2!=null){
            current.next=l2;
        }

        return pseudohead.next;
    }


    @Test
    public void t(){
        ListNode a= new ListNode(1);
        ListNode b= new ListNode(2);
        ListNode c= new ListNode(3);
        ListNode d= new ListNode(4);
        ListNode e= new ListNode(5);

        //l1
        a.next=b;
        b.next=d;

        //l2
        c.next=e;

        ListNode result = mergeTwoLists(a,c);
        System.out.println(result);
    }


    /**
     * Runtime O(n+m) - sum of the lengths of two lists. Linear time complexity
     * Space O(1). Allocating a few pointers. Constant memory footprint.
     */
}
