/*
 * @lc app=leetcode.cn id=1672 lang=java
 *
 * [1672] 最富有客户的资产总量
 */

// @lc code=start
class Solution {
    public int maximumWealth(int[][] accounts) {
        // 模拟
        return extracted(accounts);
    }

    private int extracted(int[][] accounts) {
        int summax = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                // 求和
                sum += accounts[i][j];
            }
            // 取最值
            summax = Math.max(summax, sum);
        }
        return summax;
    }
}
// @lc code=end
