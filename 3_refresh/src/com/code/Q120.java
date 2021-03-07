package com.code;

import java.util.List;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。
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
    public int minimumTotal(List<List<Integer>> triangle){
        int size = triangle.size();
        int[] trim = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            List<Integer> item = triangle.get(i);
            for (int j =  0; j < item.size(); j++ ) {
                if (i == size - 1){
                    trim[j] = item.get(j);
                }else {
                    trim[j] = Math.min(trim[j + 1], trim[j]) + item.get(j);
                }
            }

        }
        return trim[0];
    }
}
