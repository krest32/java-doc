
/*
 * @lc app=leetcode.cn id=2104 lang=java
 *
 * [2104] 子数组范围和
 */

// @lc code=start
class Solution {

    public long subArrayRanges(int[] nums) {
        // 滑动窗口
        // return extracted(nums);

        // 1
        long ret = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                ret += max - min;
            }
        }
        return ret;
    }

    private long extracted(int[] nums) {
        int n = nums.length;
        long ret = 0;
        // 单个元素也可作为自己，所以j=i
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ret += maxVal - minVal;
            }
        }
        return ret;
    }

}
// @lc code=end
