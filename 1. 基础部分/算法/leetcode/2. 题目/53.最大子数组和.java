/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // 解法一： 动态规划 --> 优化
        // return extracted(nums);

        // 解法二： 分治
        // return getInfo(nums, 0, nums.length - 1).mSum;

        // 解法三：动态规划-- 基础版
        // return extracted2(nums);

        // 1
        return test(nums);

    }

    private int test(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * Your runtime beats 39.62 % of java submissions
     * Your memory usage beats 41.74 % of java submissions (50.4 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 42.53 % of java submissions (50.3 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        // 初始化变量
        int curSum = nums[0];
        int maxSum = curSum;

        for (int i = 1; i < nums.length; i++) {
            // 分别记录每个位置的最大子数组和
            curSum = Math.max(nums[i], nums[i] + curSum);
            // 通过比较获取最大的子数组和
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public class Status {
        public int lSum, rSum, mSum, iSum;

        /**
         * 
         * @param lSum 表示 [l,r] 内以 l 为左端点的最大子段和
         * @param rSum 表示 [l,r] 内以 r 为右端点的最大子段和
         * @param mSum 表示 [l,r] 内的最大子段和
         * @param iSum 表示 [l,r] 的区间和
         */
        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    /**
     * 分治
     * 
     * 了解解题的思路
     * 
     * Your runtime beats 5.32 % of java submissions
     * Your memory usage beats 40.01 % of java submissions (50.3 MB)
     * 
     */
    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

}
// @lc code=end
