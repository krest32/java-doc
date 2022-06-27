/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        // 数学
        return extracted(x);
    }

    private int extracted(int x) {
        int ans = 0;
        int ret = 0;
        while (x != 0) {
            // 因为之后的计算，ret会*10，所以提前判断数字是否会越界
            if (ret > Integer.MAX_VALUE / 10 || ret < Integer.MIN_VALUE / 10) {
                return 0;
            }
            ans = x % 10;
            ret = ret * 10 + ans;
            x /= 10;
        }
        return ret;
    }
}
// @lc code=end
