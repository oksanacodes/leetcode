package com.example.demo.tree.BalancedBinaryTree_110;

import com.example.demo.tree.TreeNode;

public class Solution {
    /*

    Runtime: O(N*log(N)) - We need to traverse every node to calculate the depth of that node
    It means that `heaight` method will be called log(n) times for every n node.

    Space: O(n) - N is the size of the recursion stack if the tree is unbalanced.
     */

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSubtree = height(root.left);
        int rightSubtree = height(root.right);
        return 1+Math.max(leftSubtree, rightSubtree);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftSubtreeHeight = height(root.left);
        int rightSubtreeHeight = height(root.right);
        if(Math.abs(leftSubtreeHeight-rightSubtreeHeight)>1){
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }
}
