import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1877 lang=java
 *
 * [1877] 数组中最大数对和的最小值
 */

// @lc code=start
class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            // 数组的首尾值进行相加
            res = Math.max(res, nums[i] + nums[n - 1 - i]);
        }
        return res;
    }
}
// @lc code=end
