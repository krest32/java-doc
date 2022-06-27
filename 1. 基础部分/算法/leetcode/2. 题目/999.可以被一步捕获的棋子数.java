/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 可以被一步捕获的棋子数
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        return extracted(board);
    }

    /**
     * 24/24 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 44.77 % of java submissions (38.8 MB)
     * 
     * @param board
     * @return
     */
    private int extracted(char[][] board) {
        int cnt = 0, st = 0, ed = 0;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    st = i;
                    ed = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int step = 0;; ++step) {
                int tx = st + step * dx[i];
                int ty = ed + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                    break;
                }
                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
// @lc code=end
