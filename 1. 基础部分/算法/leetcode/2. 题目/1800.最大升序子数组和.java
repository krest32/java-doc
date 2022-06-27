import java.nio.Buffer;

/*
 * @lc app=leetcode.cn id=1800 lang=java
 *
 * [1800] 最大升序子数组和
 */

// @lc code=start
class Solution {
    public int maxAscendingSum(int[] nums) {
        // 贪心
        return method(nums);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 45.29 % of java submissions (39 MB)
     * 
     * @param nums
     * @return
     */
    int method(int[] nums) {
        int cur = 0;
        int cnt = 0;
        int len = nums.length;
        // 记录可能是降序的数组的情况

        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                if (cnt == 0) {
                    cur += nums[i - 1];
                }
                cur += nums[i];
                cnt++;
                ans = Math.max(ans, cur);
            } else {
                cur = 0;
                cnt = 0;
            }
        }
        return ans;
    }
}
// @lc code=end
