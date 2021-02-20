package com.code;

import com.struct.TreeNode;

import java.util.*;

/*
* 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = deque.pollLast();
                item.add(current.val);
                if (current.left != null) deque.offer(current.left);
                if (current.right != null) deque.offer(current.right);
            }
            result.add(item);
        }
        return result;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> result){
        if (root == null) return;
        if (result.size() <= level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }

}
