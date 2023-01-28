package com.example.demo.tree.MaximumDepthofBinaryTree_104;

import com.example.demo.tree.TreeNode;
import com.jayway.jsonpath.internal.function.numeric.Max;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
104. Maximum Depth of Binary Tree  https://leetcode.com/problems/maximum-depth-of-binary-tree/
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3
 */
public class SolutionRecursive {



    /*
  Runtime - O(N) - We visit each node once and perform a constant amount of work at each node.We use a stack to store all nodes to be visited.
  Each of the n nodes is added to and popped from the stack once, which takes O(1) time.

  Space - O(N) -The space is taken up by the recursive call stack. The recursion internally uses a
  call stack that takes up space equivalent to the depth of the tree.
  The max depth of the tree could be O(N) in the worst-case scenario when the tree is unbalanced.
   */


    public int maxDepth(TreeNode root){
        // Formula H(Tree) = 1+Max(H(left subtree) + H(right subtree));
        if (root==null){
            return 0;
        }
        int depthOfRightSubtree = maxDepth(root.right);
        int depthOfLeftSubtree = maxDepth(root.left);
        return 1+ Math.max(depthOfLeftSubtree, depthOfRightSubtree);
    }


    @Test
    public void t(){
        TreeNode right = new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7, null,null));
        TreeNode root = new TreeNode(3,new TreeNode(9, null,null),right);

        int result = maxDepth(root);
        assert 3== result;
    }
}
