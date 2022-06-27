/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {
    public int integerReplacement(int n) {
        // 贪心
        // return extracted(n);

        // 1
        return extracted2(n);
    }

    private int extracted2(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ans++;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 22.91 % of java submissions (38.3 MB)
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        return extracted2(n);
    }
}
// @lc code=end
