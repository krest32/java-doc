import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import javafx.scene.layout.GridPane;

/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int colums = matrix[0].length;
        int[][] dp = new int[row][colums];

        // 初始化第一行数据
        for (int i = 0; i < colums; i++) {
            dp[0][i] = matrix[0][i];
        }

        // 开始计算整个矩阵
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < colums; j++) {
                // 处于矩阵最坐标，同时可以向右边延伸
                if (j == 0 && j + 1 < colums) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                    // 处于矩阵的最右边，同时可以向左边延伸
                } else if (j == colums - 1 && j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]),
                            dp[i - 1][j]) + matrix[i][j];
                }
            }
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < colums; i++) {
            minLen = Math.min(minLen, dp[row - 1][i]);
        }
        return minLen;
    }
}
// @lc code=end
