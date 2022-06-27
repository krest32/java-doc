import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        // 数学 + 缩小问题规模
        return extracted(n, k);
    }

    /**
     * Your runtime beats 87.46 % of java submissions
     * Your memory usage beats 85.63 % of java submissions (38.5 MB)
     * 
     * @param n
     * @param k
     * @return
     */
    private String extracted(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        // 记录刻个数字的排列数
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
// @lc code=end
