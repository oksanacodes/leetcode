package com.example.demo.tree.MaximumDepthofBinaryTree_104;

import com.example.demo.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/*
BFS approach (traverse by levels)
 */
public class SolutionIterative {

    int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        //1. add the root to the queue
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i=0;i<n;i++){
                TreeNode curr = queue.poll();
                if(curr.right !=null){
                    queue.add(curr.right);
                }
                if(curr.left !=null){
                    queue.add(curr.left);
                }
            }
            depth++;
        }

        return depth;
    }

    @Test
    public void t(){
        TreeNode right = new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7, null,null));
        TreeNode root = new TreeNode(3,new TreeNode(9, null,null),right);

        int result = maxDepth(root);
        assert 3== result;
    }
}
