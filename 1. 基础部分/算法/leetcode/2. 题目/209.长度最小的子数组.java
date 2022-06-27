/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        return extracted(target, nums);
    }

    /**
     * Your runtime beats 99.99 % of java submissions
     * Your memory usage beats 5.05 % of java submissions (41.6 MB)
     * 
     * @param target
     * @param nums
     * @return
     */
    private int extracted(int target, int[] nums) {
        int n = nums.length;
        // 判断特殊情况
        if (n == 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        //
        while (end < n) {
            // 记录窗口的值
            sum += nums[end];
            // 判断满足条件的子数组
            while (sum >= target) {
                // 记录最短长度
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
// @lc code=end
