package com.example.demo.linkedList.ReorderList_143;

import com.example.demo.linkedList.ListNode;
import org.junit.jupiter.api.Test;

public class Solution {

    /*
    Time complexity: O(N). There are three steps here. To identify the middle node takes O(N)time.
    To reverse the second part of the list, one needs N/2 operations. The final step, to merge two lists,
    requires N/2N operations as well. In total, that results in O(N) time complexity.

    Space complexity: O(1), since we do not allocate any additional data structures.
     */

    public void reorderList(ListNode head) {

        //1. Find medium
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow points at medium (end of the first sublist)

        //2. Reverse second sublist

        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // curr points to null, and prev points to the head of ths second sublist

        //3. merge two sublists

        ListNode l1 = head;
        ListNode l2 = prev;

        while (l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            l1.next = l2;
            l2.next = temp1;

            l1 = temp1;
            l2 = temp2;
        }
    }

    @Test
    public void t() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);


        //l1
        a.next = b;
        b.next = c;
        c.next = d;

        // Input: head = [1,2,3,4]
        // Output: [1,4,2,3]

        reorderList(a);
        System.out.println(a);
    }
}
