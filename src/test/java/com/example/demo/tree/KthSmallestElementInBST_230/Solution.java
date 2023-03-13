package com.example.demo.tree.KthSmallestElementInBST_230;

import com.example.demo.tree.TreeNode;

import java.util.Stack;

/*
230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

Given the root of a binary search tree, and an integer k, return the kth smallest
value (1-indexed) of all the values of the nodes in the tree.


The above recursion could be converted into iteration, with the help of stack. This way
one could speed up the solution because there is no need to build the entire inorder
traversal, and one could stop after the kth element.

Runtime: O(H+k), where H is a tree height. This complexity is defined by the stack,
which contains at least H+k elements, since before starting to pop out one has to go down to a
leaf. This results in O(logN+k) for the balanced tree and O(N+k) for completely unbalanced
tree with all the nodes in the left subtree.

Space: O(H) to keep the stack, where H is a tree height.
That makes O(N) in the worst case of the skewed tree, and O(logN) in the average case
of the balanced tree.

 */
public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // ArrayList<Integer> smallestList = new ArrayList<>();
        int visited=0;

        while(current!=null || !stack.isEmpty()){

            //traverse to the left subtree - the loweste element in the tree
            while(current!=null){
                stack.push(current);
                current=current.left;
            }
            //at this point current points to null and stack is full of lowest elements of the root

            current = stack.pop();
            //smallestList.add(current.val);
            visited++;
            if(visited==k){
                return current.val;
            }
            current=current.right;
        }
        // return smallestList.get(k-1);
        return 0;
    }
}
