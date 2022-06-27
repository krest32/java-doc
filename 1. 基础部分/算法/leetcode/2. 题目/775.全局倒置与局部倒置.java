/*
 * @lc app=leetcode.cn id=775 lang=java
 *
 * [775] 全局倒置与局部倒置
 */

// @lc code=start
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        /**
         * 局部倒置和非局部倒置都是全局倒置，
         * 因此只需要检查有没有非局部倒置就可以了。
         * 这里的非局部倒置指的是 A[i] > A[j], i < j，
         * 其中 j - i > 1
         */
        int len = nums.length;
        int floor = len;
        for (int i = len - 1; i >= 2; i--) {
            floor = Math.min(floor, nums[i]);
            if (nums[i - 2] > floor)
                return false;
        }
        return true;
    }
}
// @lc code=end
