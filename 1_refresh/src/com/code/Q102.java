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
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q102 {
    public static void main(String[] args) {

    }

    //BFS主要思路就是广度优先
    public static List<List<Integer>> levelOrder(TreeNode root) {

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

    //DFS 深度优先
    public static List<List<Integer>> levelOrder(TreeNode node, int level, List<List<Integer>> result){
        if (node == null) return result;
        if (result.size() <= level) result.add(new ArrayList<>());
        result.get(level).add(node.val);
        levelOrder(node.left, level + 1, result);
        levelOrder(node.right, level + 1, result);
        return result;
    }
}
