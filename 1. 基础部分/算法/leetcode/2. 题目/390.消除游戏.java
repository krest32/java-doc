
/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
class Solution {

    public int lastRemaining(int n) {
        // 等差数列模拟
        return extracted(n);

    }

    /**
     * 3377/3377 cases passed (1 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 44.74 % of java submissions (40.6 MB)
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            // 正向
            if (k % 2 == 0) {
                a1 = a1 + step;
                // 反向
            } else {
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }
}
// @lc code=end
