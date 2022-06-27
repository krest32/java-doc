/** 
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = Math.max(sum+nums[i],nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
// @lc code=end

