/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 前缀之积
        return extracted(nums);
    }

    private int[] extracted(int[] nums) {
        int len = nums.length;
        int[] first = new int[len];
        int[] last = new int[len];
        first[0] = 1;
        for (int i = 1; i < len; i++) {
            first[i] = first[i - 1] * nums[i - 1];
        }
        last[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            last[i] = last[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            first[i] = first[i] * last[i];
        }
        return first;
    }
}
// @lc code=end
