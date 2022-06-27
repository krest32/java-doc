/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        // 模拟
        return extracted(n);
    }

    private boolean extracted(int n) {
        if (n <= 0) {
            return false;
        }
        // 分别归对于2 3 5进行整除，看最终能够得到1
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
// @lc code=end

