package com.code;

import com.struct.TreeNode;

/**
 * 二叉树搜索树的最近公共祖先
 */
public class Q235 {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
