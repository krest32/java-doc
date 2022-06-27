/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int fisrtNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (fisrtNum >= nums[i]) {
                fisrtNum = nums[i];
            } else if (secondNum >= nums[i] && nums[i] > fisrtNum) {
                secondNum = nums[i];
            } else if (nums[i] > secondNum) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
