package com.code;

import com.util.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * N皇后问题
 * 回溯：深度优先
 */
public class Q51 {

    public static void main(String[] args) {
        Q51 q51 = new Q51();
        List<List<String>> lists = q51.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println("\n");
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] item = newArea(n);
        solveNQueens(result, item, 0);
        return result;
    }


    private void solveNQueens(List<List<String>> result, char[][] area, int row) {
        if (row == area.length) {
            result.add(array2List(area));
            return;
        }
        //第row行内，可能有area.length的col选择
        for (int n = 0; n < area.length; n++) {
            if (!isValid(area, row, n)) continue;
            area[row][n] = 'Q';
            solveNQueens(result, area, row + 1);
            area[row][n] = '.';
        }
    }

    private List<String> array2List(char[][] area) {
        List<String> res = new ArrayList<>();
        for (char[] i : area) {
            res.add(String.valueOf(i));
        }
        return res;
    }

    private boolean isValid(char[][] area, int row, int col) {
        //同列
        for (int i = 0; i < row; i++) {
            if (area[i][col] == 'Q') return false;
        }
        //右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < area.length; i--, j++) {
            if (area[i][j] == 'Q') return false;
        }
        //左上
        for (int i = row--, j = col--; i >= 0 && j >= 0; i--, j--) {
            if (area[i][j] == 'Q') return false;
        }
        return true;
    }

    private char[][] newArea(int n) {
        char[][] area = new char[n][n];
        for (char[] i : area) {
            Arrays.fill(i, '.');
        }
        return area;
    }
}
