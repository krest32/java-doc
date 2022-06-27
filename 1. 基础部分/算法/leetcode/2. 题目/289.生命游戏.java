/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    int[][] direc = { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };

    public void gameOfLife(int[][] board) {
        // 判断是否为null
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int colum = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                int cnt = countAlive(i, j, board);
                // 1. 活细胞周围八个位置有两个或三个活细胞，下一轮继续活
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3))
                    board[i][j] = 3;
                // 2. 死细胞周围有三个活细胞，下一轮复活了
                if (board[i][j] == 0 && cnt == 3)
                    board[i][j] = 2;
            }
        }
        // 更新结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                board[i][j] >>= 1;
            }
        }

    }

    // 计算周围存活细胞的数量
    private int countAlive(int i, int j, int[][] board) {
        int count = 0;
        for (int[] dir : direc) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 || newi < board.length || newj >= 0 || newj < board[0].length) {
                count += (board[newi][newj] & 1);
            }
        }
        return count;
    }
}

// @lc code=end
