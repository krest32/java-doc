/*
 * @lc app=leetcode.cn id=1688 lang=java
 *
 * [1688] 比赛中的配对次数
 */

// @lc code=start
class Solution {
    public int numberOfMatches(int n) {
        // 模拟
        return extracted(n);

        // 数学
        return n - 1;
    }

    private int extracted(int n) {
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                ans += n / 2;
                n /= 2;
            } else {
                ans += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return ans;
    }
}
// @lc code=end
