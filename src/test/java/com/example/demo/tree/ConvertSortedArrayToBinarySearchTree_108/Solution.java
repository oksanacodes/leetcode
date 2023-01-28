package com.example.demo.tree.ConvertSortedArrayToBinarySearchTree_108;

import com.example.demo.tree.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

 */


public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return recursive(nums, 0, nums.length-1);

    }

    private TreeNode recursive(int[] nums, int start, int end) {

        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode();

        int middle = (start+end)/2;
        root.val = nums[middle];

        root.left=recursive(nums, start, middle-1);
        root.right = recursive(nums, middle+1, end);

        return root;
    }
}
/**
 * Run Time: O(n) since we visit each node exactly once
 * Space: O(log(n)) becuase its a balanced tree
 */
