package com.code;

import com.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 *
 *给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
public class Q111 {
    public static void main(String[] args) {

    }

    //DFS
    public static int minDepth_DFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int minLevel = Integer.MAX_VALUE;
        if (root.left != null){
            minLevel = Math.min(minLevel, minDepth_DFS(root.left));
        }
        if (root.right != null){
            minLevel = Math.min(minLevel, minDepth_DFS(root.right));
        }
        return minLevel + 1;
    }

    public static int minDepth_BFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.left == node.right) return level++;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

        }
        return level;
    }


}
