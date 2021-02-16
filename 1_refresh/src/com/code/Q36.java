package com.code;

import java.util.HashMap;

/**
 * 36. 有效的数独
 */
public class Q36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Q36 q = new Q36();
        q.isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < 81; i++) {
            int row = i / 9;
            int col = i % 9;
            char item = board[row][col];
            if (item == '.') continue;
            int value = Integer.valueOf(item);
            int boxIndex = (row / 3) * 3 + col / 3;

            HashMap<Integer, Integer> rowHash = rows[row];
            HashMap<Integer, Integer> colHash = cols[col];
            HashMap<Integer, Integer> boxHash = boxes[boxIndex];

            rowHash.put(value, rowHash.getOrDefault(value, 0) + 1);
            colHash.put(value, colHash.getOrDefault(value, 0) + 1);
            boxHash.put(value, boxHash.getOrDefault(value, 0) + 1);
            if (rowHash.get(value) > 1 || colHash.get(value) > 1 || boxHash.get(value) > 1){
                return false;
            }
        }
        return true;
    }
}
