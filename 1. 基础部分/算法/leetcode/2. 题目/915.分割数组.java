/*
 * @lc app=leetcode.cn id=915 lang=java
 *
 * [915] 分割数组
 */

// @lc code=start
class Solution {
    public int partitionDisjoint(int[] nums) {
        // return extracted(nums);

        // 1
        return test(nums);

    }

    private int test(int[] nums) {
        int max = nums[0];
        int leftMax = nums[0];
        int pos = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] >= leftMax) {
                continue;
            }
            leftMax = max;
            pos = i;
        }
        return pos + 1;
    }

    private int extracted(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int leftMax = nums[0];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            // 精华思维
            if (nums[i] >= leftMax)
                continue;
            leftMax = max;
            pos = i;
        }
        return pos + 1;
    }
}
// @lc code=end
