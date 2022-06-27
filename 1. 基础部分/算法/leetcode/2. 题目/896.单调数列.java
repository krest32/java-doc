/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        // 模拟：两次遍历 判断单调递增或者单调递减，
        // return isSorted(nums, true) || isSorted(nums, false);

        // 模拟： 一次遍历
        return extracted(nums);

    }

    /**
     * Your runtime beats 43.26 % of java submissions
     * Your memory usage beats 29.68 % of java submissions (51.5 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        boolean inc = true, dec = true;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }
            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }

    /**
     * Your runtime beats 99.47 % of java submissions
     * Your memory usage beats 23.05 % of java submissions (51.5 MB)
     * 
     * @param nums
     * @param increasing
     * @return
     */
    public boolean isSorted(int[] nums, boolean increasing) {
        int n = nums.length;
        if (increasing) {
            for (int i = 0; i < n - 1; ++i) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < n - 1; ++i) {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// @lc code=end
