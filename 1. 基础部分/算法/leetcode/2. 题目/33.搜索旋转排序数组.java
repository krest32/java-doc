
/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // 二分查找法
        return extracted(nums, target);
    }

    private int extracted(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        if (len == 1)
            return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 这里的解法有点点绕
            if (nums[mid] == target) {
                return mid;
                // 可以判断牵绊部分是递增的
            } else if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // 后半部分待定
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
