package com.code;

import com.struct.TreeNode;

/**
 * 判断一棵树是否为二叉搜索树
 * <p>
 * 方法一：递归判断
 * 方法二：中序遍历
 */
public class Q98 {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }


    public static boolean isValidBST(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val > max || root.val < min) return false;
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    static TreeNode pre = null;

    public static boolean isValidBST_(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST_(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        return isValidBST_(root.right);
    }
}
