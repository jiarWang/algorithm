package com.code;

import com.struct.TreeNode;

import java.util.TreeMap;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q98 {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 递归判断左右子树
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static boolean isValidBST(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        boolean left = isValidBST(root.left, min, root.val);
        boolean right = isValidBST(root.right, root.val, max);
        return left && right;
    }
    /**
     * 方法二： 中序遍历为递增序列
     */
}
