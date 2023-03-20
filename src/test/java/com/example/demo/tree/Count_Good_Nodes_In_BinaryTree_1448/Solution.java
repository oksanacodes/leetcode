package com.example.demo.tree.Count_Good_Nodes_In_BinaryTree_1448;

import com.example.demo.tree.TreeNode;

/*
1448. Count Good Nodes in Binary Tree
https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.


Thought process:
1. Initialize global count variable that keeps track of good nodes
2. Use DFS to traverse the tree to find and keep the track of global max.
3. If node's value is bigger or equal than globalMax, update globalMax and icrement the count.

Runtime  O(N) need to visit every node at least once
SpaceTime O(logN) - size of the recursion stack for balanced tree. If the tree is unbalanced than, space complexity is O(N)

 */
public class Solution {

    private int count=0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }
    private void dfs(TreeNode root, int max){
        if(root==null){
            return;
        }
        if(root.val>=max){
            max = Math.max(max, root.val);
            count++;
        }
        dfs(root.right, max);
        dfs(root.left, max);
    }
}
