/*
 * @lc app=leetcode.cn id=1752 lang=java
 *
 * [1752] 检查数组是否经排序和轮转得到
 */

// @lc code=start
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        // 有经过轮转
        boolean isCount = nums[0] >= nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (isCount) {
                    isCount = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
