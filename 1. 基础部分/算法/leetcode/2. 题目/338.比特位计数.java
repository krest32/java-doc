/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    // 位运算
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x = x & (x - 1);
            ones++;
        }
        return ones;
    }
}
// @lc code=end
