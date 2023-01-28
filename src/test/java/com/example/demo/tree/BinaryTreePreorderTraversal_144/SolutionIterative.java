package com.example.demo.tree.BinaryTreePreorderTraversal_144;

import com.example.demo.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
144. Binary Tree Preorder Traversal https://leetcode.com/problems/binary-tree-preorder-traversal/description/

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Input: root = [1,null,2,3]
Output: [1,2,3]
 */
public class SolutionIterative {



    /*
  Runtime - O(N) - We visit each node once and perform a constant amount of work at each node.We use a stack to store all nodes to be visited.
  Each of the n nodes is added to and popped from the stack once, which takes O(1) time.

  Space - O(N) -The space is taken up by the recursive call stack. The recursion internally uses a
  call stack that takes up space equivalent to the depth of the tree.
  The max depth of the tree could be O(N) in the worst-case scenario when the tree is unbalanced.
   */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();

        if(root==null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if(treeNode!=null){
                result.add(treeNode.val);
                stack.push(treeNode.right);
                stack.push(treeNode.left);
            }

        }
        return result;
    }




    @Test
    public void t(){
        TreeNode right = new TreeNode(2,new TreeNode(3,null,null),null);
        TreeNode root = new TreeNode(1,null,right);

        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
    }
}
