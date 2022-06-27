/*
 * @lc app=leetcode.cn id=1925 lang=java
 *
 * [1925] 统计平方和三元组的数目
 */

// @lc code=start
class Solution {
    public int countTriples(int n) {
        // 暴力破解
        return extracted(n);
    }

    /**
     * Your runtime beats 48.61 % of java submissions
     * Your memory usage beats 42.82 % of java submissions (38.1 MB)
     */
    private int extracted(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int a = i * i;
                int b = j * j;
                int c = Math.max(i, j);
                for (int k = c + 1; k <= n; k++) {
                    if (a + b == (k * k)) {
                        result += 2;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end
