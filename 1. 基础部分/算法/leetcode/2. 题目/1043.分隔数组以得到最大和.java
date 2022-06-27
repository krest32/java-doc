
/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] 分隔数组以得到最大和
 */

// @lc code=start
class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        // 动态规划
        // return extracted(arr, k);

        // 1
        return extracted2(arr, k);
    }

    private int extracted2(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len];
        for (int i = 1; i <= k; i++) {
            dp[i - 1] = getMaxValue(arr, 0, i - 1) * i;
        }
        for (int i = k; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + getMaxValue(arr, i - j + 1, i) * j);
            }
        }
        return dp[len - 1];
    }

    /**
     * Your runtime beats 44.74 % of java submissions
     * Your memory usage beats 64.66 % of java submissions (40.5 MB)
     * 
     * @param arr
     * @param k
     * @return
     */
    private int extracted(int[] arr, int k) {
        int length = arr.length;
        // 代表 0-i 最大值的和
        int[] dp = new int[length];
        for (int i = 1; i <= k; i++) {
            dp[i - 1] = getMaxValue(arr, 0, i - 1) * i;
        }
        for (int i = k; i < length; i++) {
            // 划分的数组长度小于K
            for (int j = 1; j <= k; j++) {
                dp[i] = Math.max(dp[i - j] + getMaxValue(arr, i - j + 1, i) * j, dp[i]);
            }
        }

        return dp[length - 1];
    }

    private int getMaxValue(int[] arr, int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
// @lc code=end
