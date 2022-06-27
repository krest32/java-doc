/*
 * @lc app=leetcode.cn id=1979 lang=java
 *
 * [1979] 找出数组的最大公约数
 */

// @lc code=start
class Solution {
    public int findGCD(int[] nums) {
        // 模拟 暴力
        return extracted(nums);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 66.13 % of java submissions (40.3 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = min; i >= 0; i--) {
            if (min % i == 0 && max % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
// @lc code=end
