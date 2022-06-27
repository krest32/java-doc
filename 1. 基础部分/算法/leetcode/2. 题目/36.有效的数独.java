import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 哈希表
        return extracted(board);

        // 用二维+三维数组代替哈希Map,效率上比哈希得到了提升，
        // return extracted1(board);
    }

    /**
     * Your runtime beats 99.78 % of java submissions
     * Your memory usage beats 14.71 % of java submissions (41.5 MB)
     * 
     * @param board
     * @return
     */
    private boolean extracted1(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        // 三维数组
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1
                            || columns[j][index] > 1
                            || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Your runtime beats 15.88 % of java submissions
     * Your memory usage beats 42.67 % of java submissions (41.1 MB)
     * 
     * @param board
     * @return
     */
    private boolean extracted(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] colums = new HashMap[9];
        Map<Integer, Integer>[] boxs = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            colums[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int temp = (int) ch;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    rows[i].put(temp, rows[i].getOrDefault(temp, 0) + 1);
                    colums[j].put(temp, colums[j].getOrDefault(temp, 0) + 1);
                    boxs[boxIndex].put(temp, boxs[boxIndex].getOrDefault(temp, 0) + 1);
                    if (rows[i].get(temp) > 1
                            || boxs[boxIndex].get(temp) > 1
                            || colums[j].get(temp) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end
