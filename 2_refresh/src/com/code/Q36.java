package com.code;

/**
 * 有效的数独
 */
public class Q36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowFlag = new boolean[9][9];
        boolean[][] colFlag = new boolean[9][9];
        boolean[][] boxFlag = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char tmp = board[i][j];
                int hash = tmp - '1';
                if (tmp == '.') continue;
                int boxIndex = 3 * i/3 + j/3;
                if (rowFlag[i][hash] || colFlag[j][hash] ||boxFlag[boxIndex][hash]) return false;
                rowFlag[i][hash] = true;
                colFlag[i][hash] = true;
                boxFlag[boxIndex][hash] = true;
            }
        }
        return true;
    }
}
