package com.gakki.leetcode.questions_easy.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 * @author wangxb XD
 * @date 2019-09-18
 */
public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        // 行是否有效
        for (int i = 0; i < board.length; i++) {
            List<Character> numlist = new LinkedList<>(); // 去除"."
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.'){
                    numlist.add(board[i][j]);
                }
            }
            Set<Character> numberSet = new HashSet<>(numlist);
            if (numberSet.size() < numlist.size()){
                return false;
            }
        }
        // 列是否有效
        for (int j = 0; j < board[0].length; j++) {
            List<Character> numlist = new LinkedList<>(); // 去除"."
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.'){
                    numlist.add(board[i][j]);
                }
            }
            Set<Character> numberSet = new HashSet<>(numlist);
            if (numberSet.size() < numlist.size()){
                return false;
            }
        }
        // 3x3内是否有效
        for (int cnt = 0; cnt < 9; cnt++) {
            List<Character> numlist = new LinkedList<>(); // 去除"."
            int row;      // 小方格起始横坐标
            if (cnt < 3){
                row = 0;
            }else if (cnt < 6){
                row = 3;
            }else{
                row = 6;
            }

            int col;      // 小方格起始纵坐标
            if (cnt == 0 || cnt == 3 || cnt == 6){
                col = 0;
            }else if (cnt == 1 || cnt == 4 || cnt == 7){
                col = 3;
            }else{
                col = 6;
            }
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] != '.'){
                        numlist.add(board[i][j]);
                    }
                }
            }
            Set<Character> numberSet = new HashSet<>(numlist);
            if (numberSet.size() < numlist.size()){
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new Sudoku().isValidSudoku(sudoku));

        char[][] notsudoku = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new Sudoku().isValidSudoku(notsudoku));
    }
}
