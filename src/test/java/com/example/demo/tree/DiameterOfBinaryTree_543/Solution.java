package com.example.demo.tree.DiameterOfBinaryTree_543;

import com.example.demo.tree.TreeNode;

/*
543. Diameter of Binary Tree https://leetcode.com/problems/diameter-of-binary-tree/

 */
public class Solution {

     /*

    Runtime: O(N*log(N)) - We need to traverse every node to calculate the depth of that node
    It means that `heaight` method will be called log(n) times for every n node.

    Space: O(n) - N is the size of the recursion stack if the tree is unbalanced.
     */

    int maxDiametere=0;
    public int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int rightSubtree = diameter(root.right);
        int leftSubtree = diameter(root.left);
        int diameter = rightSubtree+leftSubtree;
        maxDiametere= Math.max(maxDiametere, diameter);
        return Math.max(leftSubtree, rightSubtree)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        diameter(root);
        return maxDiametere;
    }
}
