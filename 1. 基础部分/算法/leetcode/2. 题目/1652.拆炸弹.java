/*
 * @lc app=leetcode.cn id=1652 lang=java
 *
 * [1652] 拆炸弹
 */

// @lc code=start
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        // 特殊情况 k == 0
        if (k == 0)
            return new int[n];
        // 前缀和数组，方便计算k个数的和
        int[] sum = new int[n];
        sum[0] = code[0];
        for (int i = 1; i < n; ++i) {
            sum[i] = sum[i - 1] + code[i];
        }
        // 为了不在循环中多次判断k的正负，直接分了两种情况去写
        if (k > 0) {
            for (int i = 0; i < n; ++i) {
                int x = i + k;
                if (x < n) {
                    code[i] = sum[x] - sum[i];
                } else {
                    code[i] = sum[n - 1] - sum[i] + sum[x - n];
                }
            }
        } else {
            for (int i = 0; i < n; ++i) {
                int x = i + k;
                if (x > 0) {
                    code[i] = sum[i - 1] - sum[x - 1];
                } else {
                    // i = 0时, 没有sum[i-1], 需要特判
                    code[i] = i == 0 ? 0 : sum[i - 1];
                    code[i] += sum[n - 1] - sum[n - 1 + x];
                }
            }
        }
        return code;
    }
}
// @lc code=end
