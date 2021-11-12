package com.example.demo.tree.ConvertSortedArrayToBinarySearchTree_108;

public class Main {

    public static void main(String[]args){
        int[] nums={-10,-3,0,5,9};
        Solution solution = new Solution();
        TreeNode BST= solution.sortedArrayToBST(nums);
        System.out.println(BST);

    }
}
