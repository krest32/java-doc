import java.util.DuplicateFormatFlagsException;

import javax.swing.text.AbstractDocument.BranchElement;

/*
 * @lc app=leetcode.cn id=1712 lang=java
 *
 * [1712] 将数组分成三个子数组的方案数
 */

// @lc code=start
class Solution {
    public int waysToSplit(int[] nums) {
        // 暴力 -- > 但是超时
        // return extracted(nums);

        // 三指针，双指针定义左右，第三指针划分区域
        return extracted3(nums);
    }

    /**
     * Your runtime beats 92.31 % of java submissions
     * Your memory usage beats 23.62 % of java submissions (49.4 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted3(int[] nums) {
        int res = 0;
        final int mod = 1000000007;
        int[] s = new int[nums.length + 1];
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        for (int i = 3, j = 2, k = 2; i < s.length; i++) {
            while (j < i && s[j - 1] <= s[i - 1] - s[j - 1]) {
                j++;
            }
            while (s[s.length - 1] - s[i - 1] < s[i - 1] - s[k - 1]) {
                k++;
            }
            res += Math.max(0, j - k);
            res = res % mod;
        }
        return res;
    }

    /**
     * 超时
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int mod = 1000000000 + 7;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        // 记录累加和
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        int sum = dp[len - 1];
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int pre = dp[j];
                int cur = dp[i] - dp[j];
                int last = sum - dp[i];
                if (pre <= cur && cur <= last) {
                    count = (count + 1) % mod;
                }
            }
        }
        return count % mod;
    }

    /**
     * 超时
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        int mod = 1000000000 + 7;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];

        // 记录累加和
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        // 第二个指针一定大于三分之一

        int sum = dp[len - 1];
        int count = 0;
        for (int i = 0; i < len; i++) {
            // 剪纸一
            int last = sum - dp[i];
            if (last < sum / 3) {
                break;
            }
            for (int j = 0; j < i; j++) {
                int pre = dp[j];

                int cur = dp[i] - dp[j];
                // 剪枝二
                if (cur < pre) {
                    break;
                }
                if (pre <= cur && cur <= last) {
                    count = (count + 1) % mod;
                }
            }
        }
        return count % mod;
    }

}
// @lc code=end
