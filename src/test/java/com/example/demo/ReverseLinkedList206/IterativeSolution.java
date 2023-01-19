package com.example.demo.ReverseLinkedList206;

import com.example.demo.linkedList.ListNode;
import org.junit.jupiter.api.Test;

public class IterativeSolution {
    /*
    Runtime: O(n), where n is the length of the list
    Spacetime: O(1), no new DS were created, used only temporary variables to store pointers
     */
    public ListNode iterativeSolution(ListNode head){
        ListNode cur= head;
        ListNode prev = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur = next;
        }
        //reached the tail => prev is the first element in the list which makes it a head
        return prev;
    }

    @Test
    public void t(){
        ListNode a= new ListNode(1);
        ListNode b= new ListNode(2);
        ListNode c= new ListNode(3);
        ListNode d= new ListNode(4);
        ListNode e= new ListNode(5);

        a.next=b;
        b.next=c;
        c.next =d;
        d.next=e;
        e.next=null;

        ListNode result = iterativeSolution(a);
        printList(result);
    }
    public void printList(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
