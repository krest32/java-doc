/*
 * @lc app=leetcode.cn id=2016 lang=java
 *
 * [2016] 增量元素之间的最大差值
 */

// @lc code=start
class Solution {
    public int maximumDifference(int[] nums) {
        // 动态规划
        return extracted(nums);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 44.37 % of java submissions (40.7 MB)
     */
    private int extracted(int[] nums) {
        int ret = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min >= nums[i]) {
                min = nums[i];
            } else if (ret < nums[i] - min) {
                ret = nums[i] - min;
            }
        }

        return ret;
    }
}
// @lc code=end
