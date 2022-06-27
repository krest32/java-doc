/*
 * @lc app=leetcode.cn id=2239 lang=java
 *
 * [2239] 找到最接近 0 的数字
 */

// @lc code=start
class Solution {
    public int findClosestNumber(int[] nums) {
        return extracted(nums);
    }

    /**
     * Your runtime beats 37.4 % of java submissions
     * Your memory usage beats 91.03 % of java submissions (41.2 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            int absNum = Math.abs(num);
            if (absNum < Math.abs(ans)
                    || (absNum == Math.abs(ans) && num > ans)) {
                ans = num;
            }
        }
        return ans;
    }
}
// @lc code=end
