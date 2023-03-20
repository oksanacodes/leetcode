package com.example.demo.tree.BinaryTreeRightSideView_199;

import com.example.demo.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/description/

Given the root of a binary tree, imagine yourself standing on the right
side of it, return the values of the nodes you can see ordered from top to
 bottom.

Time complexity: O(N) since one has to visit each node.

Space complexity: O(N) is the queue size. This level could contain up to N/2 tree nodes in the case of
a complete binary tree
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        TreeNode current = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                current = queue.poll();
                if(i==0){
                    result.add(current.val);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
                if(current.left!=null){
                    queue.add(current.left);
                }
            }
        }
        return result;
    }

}
