import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1191 lang=java
 *
 * [1191] K 次串联后最大子数组之和
 */

// @lc code=start
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        // 分类讨论
        return extracted(arr, k);
    }

    /**
     * 42/42 cases passed (3 ms)
     * Your runtime beats 82.88 % of java submissions
     * Your memory usage beats 78.77 % of java submissions (48.6 MB)
     * 
     * @param arr
     * @param k
     * @return
     */
    private int extracted(int[] arr, int k) {
        int n = arr.length;
        int m = 2 * n;
        long dp = 0, max = 0;
        int mod = 1000000007;
        long sum = 0;
        // 情况1 k<2 返回 最大子数组和
        if (k < 2) {
            for (int i = 0; i < n; i++) {
                if (dp >= 0) {
                    dp += arr[i];
                } else {
                    dp = arr[i];
                }
                if (dp > max)
                    max = dp;
            }
            return (int) max;
        }
        // 记录挡圈数组的和
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        // 记录关联在一起的两个子树组和
        for (int i = 0; i < m; i++) {
            if (dp >= 0) {
                dp += arr[i % n];
            } else {
                dp = arr[i % n];
            }
            if (dp > max)
                max = dp;
        }
        // 如果关联在一期>0,则记录所有数组串联的结果
        if (sum > 0)
            return (int) ((max + (k - 2) * sum) % mod);
        // 否则返回当前数组的最大子数组和
        return (int) (max % mod);
    }
}
// @lc code=end
