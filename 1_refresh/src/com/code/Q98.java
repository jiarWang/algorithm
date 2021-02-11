package com.code;

import com.struct.TreeNode;

/**
 * Valiedate BST（Binary Search Tree）
 * 判断一棵树是否是二叉搜索树
 * <p>
 * 1、左子树上的所有节点小于根节点
 * 2、右子树上的所有节点小于根节点
 * 3、所有子树遵守1、2
 * <p>
 * 空树也属于BST
 * <p>
 * 解法1：中序遍历 结果为升序
 * 解法2：递归
 */
public class Q98 {
    public static void main(String[] args) {

    }

    public static TreeNode pre = null;

    /**
     * 解法一
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);
    }

    /**
     * 递归，左子树上的节点小于根节点，右子树上的节点大于根节点
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    public static boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }


}
