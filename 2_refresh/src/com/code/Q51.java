package com.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        solveQueens(result, item, 0);
        return result;
    }

    private char[][] newArea(int n) {
        char[][] result = new char[n][n];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], '.');
        }
        return result;
    }

    private void solveQueens(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            List<String> resultItem = new ArrayList<>();
            for (char[] chars : board) {
                resultItem.add(String.valueOf(chars));
            }
            result.add(resultItem);
            return;
        }

        //0~result.size()列
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)){
                board[row][i] = 'Q';
                solveQueens(result, board, row + 1);
                board[row][i] = '.';
            }
        }

    }

    private boolean isValid(char[][] board, int row, int col) {
        //同列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        //左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
