package com.util;

import com.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeUtils {

    public static void main(String[] args) {
        TreeNode tree = newTree(10);
        prePrint(tree);
        System.out.println("");
        centerPrint(tree);
        System.out.println("");
        endPrint(tree);
        System.out.println("");
        expendTree(tree);
    }

    public static TreeNode newTree(int size) {
        TreeNode[] nodes = new TreeNode[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new TreeNode(new Random().nextInt(size * 10));
        }
        for (int i = 0; i < (size - 1) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < size) {
                nodes[i].left = nodes[left];
            }
            if (right < size) {
                nodes[i].right = nodes[right];
            }
        }
        return nodes[0];
    }


    public static void prePrint(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + "-->");
        prePrint(node.left);
        prePrint(node.right);
    }

    public static void centerPrint(TreeNode node) {
        if (node == null) return;
        centerPrint(node.left);
        System.out.print(node.val + "-->");
        centerPrint(node.right);
    }

    public static void endPrint(TreeNode node) {
        if (node == null) return;
        endPrint(node.left);
        endPrint(node.right);
        System.out.print(node.val + "-->");
    }

    /**
     * 广度优先
     * @param root
     */
    public static void expendTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            System.out.print(node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }
}
