/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {

    public int hammingWeight(int n) {
        int ret = 0;
        // 遍历 32 次，
        // 使用 n & 1 得到二进制末尾是否为 1；
        // 把 n 右移 1 位，直至结束。
        for (int i = 0; i < 32; i++) {
            //
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
// @lc code=end
