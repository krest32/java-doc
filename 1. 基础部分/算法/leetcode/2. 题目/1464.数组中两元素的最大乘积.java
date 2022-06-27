import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1464 lang=java
 *
 * [1464] 数组中两元素的最大乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 2) {
            return nums[nums.length - 1];
        } else {
            return (nums[nums.length - 1] - 1)
                    * (nums[nums.length - 2] - 1);
        }
    }
}
// @lc code=end
