package com.code;

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
public class Q79 {
    public static void main(String[] args) {

    }

    private int row = 0;
    private int col = 0;
    private char[] chars;
    private int len;

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (word == null || word.isEmpty()) return true;
        row = board.length;
        col = board[0].length;
        chars = word.toCharArray();
        len = chars.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(board, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     * 在board中第[x][y]是否与String[n]相等
     * @param board
     * @param x
     * @param y
     * @param n
     * @return
     */
    private boolean search(char[][] board, int x, int y, int n) {
        if (x < 0 || y < 0 || x >= row || y >= col || n >= len || board[x][y] != chars[n]) return false;
        if (n == len - 1) return true;
        char tmp = board[x][y];
        board[x][y] = 0;
        boolean result = search(board, x - 1, y, n + 1)
                || search(board, x + 1, y, n + 1)
                || search(board, x, y - 1, n + 1)
                || search(board, x, y + 1, n + 1);
        board[x][y] = tmp;
        return result;
    }
}
