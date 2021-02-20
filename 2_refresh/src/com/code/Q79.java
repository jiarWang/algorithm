package com.code;

/**
 * 单词搜索
 */
public class Q79 {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, int row, int col, int n, String word) {
        if (row <= 0 || col <= 0 || row >= board.length || col >= board[row].length || n >= word.length()) return false;
        if (board[row][col] == word.charAt(n) && n == word.length() - 1) return true;
        char tmp = board[row][col];
        board[row][col] = 0;
        boolean left = search(board, row - 1, col, n + 1, word);
        boolean right = search(board, row + 1, col, n + 1, word);
        boolean up = search(board, row, col - 1, n + 1, word);
        boolean down = search(board, row, col + 1, n + 1, word);
        board[row][col] = tmp;
        return left || right || up || down;
    }
}
