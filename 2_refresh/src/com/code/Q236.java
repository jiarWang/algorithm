package com.code;

import com.struct.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class Q236 {
    public static void main(String[] args) {

    }
    public static TreeNode commonNode(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;
        TreeNode left = commonNode(root.left, p, q);
        TreeNode right = commonNode(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        if (right == null) return left;
        return null;
    }
}
