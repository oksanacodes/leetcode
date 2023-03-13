package com.example.demo.tree.ValidateBinarySearchTree_98;

import com.example.demo.tree.TreeNode;

/*

98. Validate Binary Search Tree https://leetcode.com/problems/validate-binary-search-tree/

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Runtime: O(N) since we visit each node exactly once.
Space: O(N) due to size of the recursion stack.

 */
public class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return false;
            }

            return isBST(root, null, null);
        }

        private boolean isBST(TreeNode root, Integer max, Integer min){
            if(root==null){
                return true;
            }

            if((max!=null && root.val>=max) || (min!=null &&root.val<=min)){
                return false;
            }
            return isBST(root.right, max, root.val) && isBST(root.left, root.val, min);
        }
}
