/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int target = 0;
        for(int i=0; i<nums.length; i++){
            target= target^nums[i];
        }
        return target;
    }
}
// @lc code=end

