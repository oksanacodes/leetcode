package com.example.demo.linkedList.AddTwoNumbers_2;

import com.example.demo.linkedList.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 2. Add Two Numbers https://leetcode.com/problems/add-two-numbers/
 *
 * 1. Introduce v1, v2, and carry variables.
 * 2. If we reach the end of l1, set v1=0, otherwise set it to l1.val
 * 3. If we reach teh end of l2, set v2=0, otherwise set it to l2.val
 * 4. calculate sum = v1+v2+carry;
 * 5. update carry = sum/10;
 * 6. create a new node where value = sum mod 10. E.g. 7+5+0 = 14. I means carry =14/10=1, val = 14%10=4
 * 7. update pointers for l1, l2, and current
 * 8. if in the end of traversing l1 and l2, the carry>0, then create a new node, and set its value = carry.
 *
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pseudohead = new ListNode(-1);
        ListNode current = pseudohead;
        int carry=0;
        int v1=0;
        int v2=0;



        while(l1!=null || l2!=null){
            v1= (l1 ==null)? 0: l1.val;
            v2= (l2==null)? 0: l2.val;
            int sum = v1+v2+carry;
            carry = sum/10;
            int val = sum%10;

           if(l1!=null){
               l1 = l1.next;
           }
           if(l2 !=null){
               l2= l2.next;
           }
            current.next = new ListNode(val);
            current=current.next;
        }
        if(carry>0){
            current.next = new ListNode(carry);
        }
        return pseudohead.next;
    }


    @Test
    public void t(){
        ListNode a= new ListNode(2);
        ListNode b= new ListNode(4);
        ListNode c= new ListNode(3);

        ListNode d= new ListNode(5);
        ListNode e= new ListNode(6);
        ListNode f= new ListNode(4);

        //l1
        a.next=b;
        b.next=c;


        //l2
        d.next=e;
        e.next=f;

        ListNode result = addTwoNumbers(a,d);
        System.out.println(result);
    }

    /**
     * Runtime O(n) - iterate the linkedList where n is the number of nodes
     * Space O(n) - create a new linkedList where n is the number of nodes
     */
}
