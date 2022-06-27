/*
 * @lc app=leetcode.cn id=419 lang=java
 *
 * [419] 甲板上的战舰
 */

// @lc code=start
class Solution {
    public int countBattleships(char[][] board) {
        // 图的层次遍历
        return extracted(board);
    }

    private int extracted(char[][] board) {
        int rows = board.length;
        int colums = board[0].length;

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    dfs(board, i, j);
                }
            }
        }
        return ans;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 5.06 % of java submissions (41.1 MB)
     */
    private void dfs(char[][] board, int i, int j) {
        int rows = board.length;
        int colums = board[0].length;
        if (i < 0 || i >= rows || j < 0 || j >= colums || board[i][j] == '.') {
            return;
        } else {
            board[i][j] = '.';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
}
// @lc code=end
