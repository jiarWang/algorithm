package com.code;

//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
//
//
// 上图是一个部分填充的有效的数独。
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。
//
// 示例 1:
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
public class Q36 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHash = new boolean[9][9];
        boolean[][] colHash = new boolean[9][9];
        boolean[][] boxHash = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '1';

                if (rowHash[i][curNum] || colHash[i][curNum] || boxHash[3 * i / 3 + curNum / 3][curNum]) return false;
                rowHash[i][curNum] = true;
                colHash[i][curNum] = true;
                colHash[3 * i / 3 + curNum / 3][curNum] = true;
            }
        }
        return true;
    }
}
