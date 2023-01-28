package com.example.demo.tree.BinaryTreeLevelOrderTraversal_102;

import com.example.demo.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /*
    Time complexity : O(N) since each node is processed exactly once.

    Space complexity : O(N) to keep the output structure which contains N node values.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);

        while(!queue.isEmpty()){
            // create current level
            result.add(new ArrayList<>());
            // pop all elements from the queue
            int n = queue.size();
            for (int i=0;i<n;i++) {
                TreeNode current = queue.remove();
                if (current != null) {
                    // fullfil current level
                    result.get(level).add(current.val);
                }
                // add children to the queue for the next iteration
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
        }
        return result;

    }
    @Test
    public void t(){
        TreeNode right = new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7, null,null));
        TreeNode root = new TreeNode(3,new TreeNode(9, null,null),right);

        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }
}
