package com.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class Q120 {

    public static void main(String[] args) {
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Q120 q = new Q120();
        System.out.println(q.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] cost = new int[triangle.get(triangle.size() - 1).size()];
        //行遍历
        for (int i = 0; i < triangle.size(); i++) {
            //列遍历
            List<Integer> rowList = triangle.get(i);
            for (int j = rowList.size() - 1; j >= 0; j--) {
                int currentValue = triangle.get(i).get(j);
                if (j == 0) cost[j] = cost[j] + currentValue;
                else if (j == rowList.size() - 1) cost[j] = cost[j - 1] + currentValue;
                else {
                    cost[j] = Math.min(cost[j - 1] + currentValue, cost[j] + currentValue);
                }
            }
        }
        int min = cost[0];
        for (int total : cost) {
            if (total < min) min = total;
        }
        return min;
    }
}
