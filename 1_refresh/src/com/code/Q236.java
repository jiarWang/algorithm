package com.code;

import com.struct.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class Q236 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null || root == p || root == q) return root;//如果其中一个就是root就返回root
        TreeNode left = lowestCommonAncestor(root.left, p, q);//在左子树中找
        TreeNode right = lowestCommonAncestor(root.right, p, q);//在右子树中找
        /**
         *          if (left != null && right != null) {
         *             return root; //分布在左右两边
         *         } else if (left != null) {
         *             return left; //在左边
         *         } else if (right != null) {
         *             return right; //在右边
         *         }
         *         return null;
         */
        return left == null ? right : right == null? left:root;
    }
}
