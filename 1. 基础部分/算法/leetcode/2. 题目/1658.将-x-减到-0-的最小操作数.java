import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1658 lang=java
 *
 * [1658] 将 x 减到 0 的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int curSum = 0;
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            if (right < nums.length) {
                curSum += nums[right++];
            }
            while (curSum > sum - x && left < nums.length) {
                curSum -= nums[left++];
            }
            if (curSum == sum - x) {
                maxPart = Math.max(maxPart, right - left);
            }
            if (right == nums.length) {
                left++;
            }
        }
        return maxPart == -1 ? -1 : nums.length - maxPart;
    }
}
// @lc code=end
