package com.code;

import com.struct.TreeNode;

/**
 * 树的最小高度
 * DFS实现
 */
public class Q111 {
    public static void main(String[] args) {

    }
    public static int minDepth(TreeNode node){
        if (node == null) return 0;
        if (node.left == node.right && node.left == null) return 1;
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        if (node.left == null){
            return right + 1;
        }else if (node.right == null){
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

}
