import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        // 动态规划
        return extracted(grid);

        // 广度优先算法 性能太差
        // return extracted2(grid);

    }

    /**
     * Time Limit Exceeded
     * 61/61 cases passed (N/A)
     * 
     * @param grid
     * @return
     */
    private int extracted2(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int colums = grid[0].length;
        int[][] dp = new int[rows][colums];
        int cur = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < rows; i++) {
            cur += grid[i][0];
        }
        for (int i = 0; i < colums; i++) {
            cur += grid[rows - 1][i];
        }
        // 在队列中放入数组，分别记录到达这个位置的
        queue.offer(new int[] { 0, 0, grid[0][0] });

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int curi = arr[0];
                int curj = arr[1];
                int val = arr[2];
                if (val >= dp[curi][curj] || val >= cur) {
                    continue;
                } else {
                    dp[curi][curj] = val;
                }
                if (curi == rows - 1 && curj == colums - 1) {
                    cur = Math.min(cur, val);
                }
                // 向左前進
                if (curi + 1 < rows) {
                    queue.offer(new int[] { curi + 1, curj, val + grid[curi + 1][curj] });
                }
                // 向下前进
                if (curj + 1 < colums) {
                    queue.offer(new int[] { curi, curj + 1, val + grid[curi][curj + 1] });
                }
            }
        }
        return cur;
    }

    /**
     * 61/61 cases passed (2 ms)
     * Your runtime beats 94.53 % of java submissions
     * Your memory usage beats 47.74 % of java submissions (43.9 MB)
     * 
     * @param grid
     * @return
     */
    private int extracted(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        // 记录走到每一个方格的最小花费
        int[][] dp = new int[rows][colums];
        dp[0][0] = grid[0][0];
        // 横行一直向右前进
        for (int i = 1; i < colums; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // 竖行一直向下前进
        for (int i = 1; i < rows; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < colums; j++) {
                // 以此记录到达每个位置的最小路径和
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][colums - 1];
    }
}
// @lc code=end
