package com.code;

import com.struct.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class Q235 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
