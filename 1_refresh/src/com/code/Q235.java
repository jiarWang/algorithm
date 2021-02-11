package com.code;

import com.struct.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class Q235 {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root.value == p.value || root.value == q.value) return root;
        if (p.value < root.value && q.value < root.value){
            //找左边
            return lowestCommonAncestor(root.left, p, q);
        }else if (p.value > root.value && q.value > root.value){
            //找右边
            return lowestCommonAncestor(root.right, p, q);
        }else {
            //分布在左右子树，只能选root
            return root;
        }
    }
}
