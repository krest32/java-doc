/*
 * @lc app=leetcode.cn id=1716 lang=java
 *
 * [1716] 计算力扣银行的钱
 */

// @lc code=start
class Solution {
    public int totalMoney(int n) {
        // 模拟： 暴力计算 
        return extracted(n);
    }

    private int extracted(int n) {
        int week = 1, day = 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += week + day - 1;
            day++;
            if (day == 8) {
                day = 1;
                week++;
            }
        }
        return res;
    }
}
// @lc code=end
