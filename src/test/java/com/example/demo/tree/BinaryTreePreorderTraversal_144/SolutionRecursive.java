package com.example.demo.tree.BinaryTreePreorderTraversal_144;

import com.example.demo.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
144. Binary Tree Preorder Traversal https://leetcode.com/problems/binary-tree-preorder-traversal/description/

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Input: root = [1,null,2,3]
Output: [1,2,3]
 */
public class SolutionRecursive {

    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        this.result = new ArrayList<>();
        recursive(root);
        return result;
    }
    /*
    Runtime - O(N) - We visit each node once and perform a constant amount of work at each node.
    Space - O(N) -The space is taken up by the recursive call stack. The recursion internally uses a
    call stack that takes up space equivalent to the depth of the tree.
    The max depth of the tree could be O(N) in the worst-case scenario when the tree is unbalanced.

    RreOrder Traversal          value-> left child - > right child
    InOrder Traversal           left child - > value-> right child
     */

    public void recursive(TreeNode root){
        if(root==null){
            return;
        }
        result.add(root.val);

        recursive(root.left);
        recursive(root.right);
    }


    @Test
    public void t(){
        TreeNode right = new TreeNode(2,new TreeNode(3,null,null),null);
        TreeNode root = new TreeNode(1,null,right);

        List<Integer> result = preorderTraversal(root);
        System.out.println(result);
    }
}
