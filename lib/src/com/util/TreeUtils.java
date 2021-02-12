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

        levelTree(tree);
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
     *
     * @param root
     */
    public static void expendTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + ",");
            //可以创建一个set存储已访问的埋点，将排除已访问的节点，这样就可以实现图的遍历了
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public static void levelTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level ++;
            System.out.println(String.format("\n当前层：%d", level));
            int size = queue.size();//每次将当前层遍历完毕
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + ",");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }
}
