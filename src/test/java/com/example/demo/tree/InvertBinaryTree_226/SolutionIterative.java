package com.example.demo.tree.InvertBinaryTree_226;

import com.example.demo.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionIterative {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode current = queue.poll();
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

        }
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
