import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        // 模拟
        return extracted(nums);
    }

    private int extracted(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(mid - num);
        }
        return sum;
    }
}
// @lc code=end
