/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // return extracted(nums, k);

        // 1
        return extracted2(nums, k);
    }

    private int extracted2(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int pos = 1;
        int ans = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            pos *= nums[i];
            while (pos >= k) {
                pos /= nums[left];
                left++;
            }
            ans += i - left + 1;
        }
        return ans;
    }

    private int extracted(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k)
                prod /= nums[left++];
            // 这个区间里的都是满足条件的
            ans += right - left + 1;
        }
        return ans;
    }
}
// @lc code=end
