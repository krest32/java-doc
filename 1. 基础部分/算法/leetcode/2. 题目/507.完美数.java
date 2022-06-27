/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        // 暴力模拟
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            // 对所有的乘积因子进行累加
            if (num % i == 0) {
                sum = sum + i;
                if (i * i < num) {
                    sum = sum + num / i;
                }
            }
        }
        return sum == num;
    }
}
// @lc code=end
