package com.code;

import com.struct.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Q102 {
    public static void main(String[] args) {

    }

    /**
     * BFS实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> resultItem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                resultItem.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(resultItem);
        }
        return result;
    }

    /**
     * DFS
     * @param root
     * @param level
     * @param result
     */
    public void levelOrder(TreeNode root, int level, List<List<Integer>> result){
        if (root == null) return;
        if(result.size() <= level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        levelOrder(root.left, level + 1, result);
        levelOrder(root.right, level + 1, result);
    }
}
