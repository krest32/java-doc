/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxValue = new int[len];
        int[] minValue = new int[len];
        System.arraycopy(nums, 0, maxValue, 0, len);
        System.arraycopy(nums, 0, minValue, 0, len);
        for (int i = 1; i < len; i++) {
            maxValue[i] = Math.max(maxValue[i - 1] * nums[i], Math.max(nums[i], minValue[i - 1] * nums[i]));
            minValue[i] = Math.min(minValue[i - 1] * nums[i], Math.min(nums[i], maxValue[i - 1] * nums[i]));
        }
        int ans = maxValue[0];
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, maxValue[i]);
        }
        return ans;

    }
}
// @lc code=end
