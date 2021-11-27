package com.example.demo.linkedList.IntersectionOfTwoLinkedLists_160;

import com.example.demo.linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 *
 * 1. Traverse listA and store adressses/references to another nodes in a set
 * 2. Traverse listB and check if node in a listB is in the set. If it is, we found intersected node. If not, return null
 * We are comparing objectes of type Node. We should not compare values of the nodes.
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while(headA!=null){
            visited.add(headA);
            headA = headA.next;
        }

        while(headB!=null){
            if(visited.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
    return null;
    }
    /**
     * Runtime:  O(n+m), where n is the number of nodes in A list, and m is the number of nodes in B list.
     *             O(1) ot insert a node in the hashset and O(1) to check if the node in the set.
     * SpaceTime: O(n). As we are storing each of the nodes from list B into a hash table, the hash table will require O(n) space.
     */
}
