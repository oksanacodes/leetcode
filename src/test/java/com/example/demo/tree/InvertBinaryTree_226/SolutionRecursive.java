package com.example.demo.tree.InvertBinaryTree_226;

import com.example.demo.tree.TreeNode;
import org.junit.jupiter.api.Test;

public class SolutionRecursive {
    /*
     Runtime - O(N) - We visit each node once and perform a constant amount of work at each node.We use a stack to store all nodes to be visited.
  Each of the n nodes is added to and popped from the stack once, which takes O(1) time.

  Space - O(N) -The space is taken up by the recursive call stack. The recursion internally uses a
  call stack that takes up space equivalent to the depth of the tree.
  The max depth of the tree could be O(N) in the worst-case scenario when the tree is unbalanced.
     */

    public TreeNode invertTree(TreeNode root) {
        if(root== null){
            return root;
        }

        // perform swap
        TreeNode temp = root.right;
        root.right=root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    @Test
    public void t(){
        TreeNode right = new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7, null,null));
        TreeNode root = new TreeNode(3,new TreeNode(9, null,null),right);

        TreeNode result = invertTree(root);
        System.out.println(result);
    }
}
