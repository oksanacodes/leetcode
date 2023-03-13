package com.example.demo.tree.SubtreeOfAnotherTree_572;

import com.example.demo.tree.TreeNode;

/*
572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure
 and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.


RunTime: O(MN). For every N node in the tree, we check if the tree rooted at node is identical to subRoot.
This check takes O(M) time, where M is the number of nodes in subRoot. Hence, the overall time complexity is O(MN).

Space O(n) is the size of recursion stack

 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }
    private boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        // if one of the trees are null
        if(p==null || q==null ){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.right,q.right) && isSameTree(p.left, q.left);
    }
}
