import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1991 lang=java
 *
 * [1991] 找到数组的中间位置
 */

// @lc code=start
class Solution {
    public int findMiddleIndex(int[] nums) {
        // 求和
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 判断条件
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
// @lc code=end
