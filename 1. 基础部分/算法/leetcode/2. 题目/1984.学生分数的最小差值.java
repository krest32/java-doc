import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1984 lang=java
 *
 * [1984] 学生分数的最小差值
 */

// @lc code=start
class Solution {
    public int minimumDifference(int[] nums, int k) {
        // 排序+滑动窗口
        return extracted(nums, k);
    }

    private int extracted(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}
// @lc code=end
