/**
 * @lc app=leetcode.cn id=34 lang=java
 *
 *     [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 合理使用二分查找法
        return extracted(nums, target);
    }

    private int[] extracted(int[] nums, int target) {
        int start = find(nums, target);
        int end = find(nums, target + 1);
        if (start == nums.length || nums[start] != target) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { start, end - 1 };
        }
    }

    private int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
// @lc code=end
