package com.example.demo.ReverseLinkedList206;

import com.example.demo.linkedList.ListNode;
import org.junit.jupiter.api.Test;

public class RecursiveSolution {
    /*
    Great video explanation is https://www.youtube.com/watch?v=S92RuTtt9EE

    Runtime: O(n), where n is the length of the list
    Spacetime: O(n), no new DS were created, used only temporary variables to store pointers. But
    The extra space comes from implicit stack space due to recursion. The recursion could go up to N levels deep.

     */
    public ListNode recursiveSolution(ListNode node){
        if(node==null || node.next == null){
            return node;
        }

        ListNode head = recursiveSolution(node.next);
        node.next.next=node;
        node.next=null;
        return head;
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

        ListNode result = recursiveSolution(a);
        printList(result);
    }
    public void printList(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
