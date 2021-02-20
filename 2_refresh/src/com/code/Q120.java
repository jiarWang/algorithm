package com.code;

import java.util.List;

// 三角形最小路径和
//
// 给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//
//
//
// 示例 1：
//
//
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
public class Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dir = new int[size][size];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == size - 1){
                    //最后一行
                    dir[i][j] = triangle.get(i).get(j);
                }else {
                    //当前行 = 下一行的两个Min + 自身值
                    dir[i][j] = Math.min(dir[i + 1][j], dir[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dir[0][0];
    }

    /**
     * 内存优化
     */
    public int _minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dir = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == size - 1){
                    //最后一行
                    dir[j] = triangle.get(i).get(j);
                }else {
                    //当前行 = 下一行的两个Min + 自身值
                    dir[j] = Math.min(dir[j], dir[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dir[0];
    }
}
