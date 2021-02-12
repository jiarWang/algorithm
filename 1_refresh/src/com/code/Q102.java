package com.code;

import com.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Q102 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //主要思路就是广度优先
        List<List<Integer>> result = new ArrayList<>();
        if (root != null){
            int level = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                result.add(new ArrayList<>());
                //将没一层的节点遍历完成
                for(int i = 0; i < size; i ++){
                    TreeNode node = queue.poll();
                    result.get(level).add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                level ++;
            }
        }
        return result;
    }
}
