package com.code;

import com.struct.TreeNode;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Q111 {
    public static void main(String[] args) {

    }

    public static class BSF{

    }

    public static class DFS{
        public static int minDepth(TreeNode node){
            if (node == null) return 0;
            if (node.left == null && node.right == null) return 1;
            int left = minDepth(node.left);
            int right = minDepth(node.right);
            return 1 + Math.min(left, right);
        }
    }
}
