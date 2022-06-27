/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // 二分查找
        int l = 0;
        int h = n;
        while (l <= h) {
            long mid = l + (h - l) / 2;
            long cost = mid * (mid + 1) / 2;
            if (cost == n)
                return (int) mid;
            else if (cost > n)
                h = (int) mid - 1;
            else
                l = (int) mid + 1;
        }
        return h;
    }
}
// @lc code=end
