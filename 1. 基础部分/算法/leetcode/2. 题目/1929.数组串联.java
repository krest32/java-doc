/*
 * @lc app=leetcode.cn id=1929 lang=java
 *
 * [1929] 数组串联
 */

// @lc code=start
class Solution {
    public int[] getConcatenation(int[] nums) {
        // 模拟
        return extracted(nums);
    }

    /**
     * 91/91 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 77.09 % of java submissions (41.6 MB)
     * 
     * @param nums
     * @return
     */
    private int[] extracted(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len * 2];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[i];
            ans[i + len] = nums[i];
        }
        return ans;
    }
}
// @lc code=end
