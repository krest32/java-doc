import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1626 lang=java
 *
 * [1626] 无矛盾的最佳球队
 */

// @lc code=start
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        if (scores.length == 1)
            return scores[0];

        // 组合二维数组
        int[][] arr = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        // 先根据年龄排序，如果年龄相同，根据分数排序，升序序
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        // 动态规划数组
        int[] dp = new int[scores.length];

        // 记录排序后的得分
        for (int i = 0; i < scores.length; i++) {
            dp[i] = arr[i][1];
        }

        // 动态规划基本思路
        int ans = 0;
        for (int i = 0; i < scores.length; i++) {
            // 找在i之前有没有比i小的
            for (int j = 0; j < i; j++) {
                if (arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
// @lc code=end
