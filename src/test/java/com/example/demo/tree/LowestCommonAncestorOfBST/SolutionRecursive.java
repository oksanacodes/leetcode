package com.example.demo.tree.LowestCommonAncestorOfBST;

import com.example.demo.tree.TreeNode;

/*
235. Lowest Common Ancestor of a Binary Search Tree

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class SolutionRecursive {
    /*
    Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.

    Space Complexity: O(N). This is because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be NNN.
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(parentVal>qVal && parentVal>pVal){
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        }else if(parentVal<qVal && parentVal<pVal){
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p,q);
        }else{
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }



}
