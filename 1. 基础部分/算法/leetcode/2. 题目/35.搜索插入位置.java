import javax.lang.model.util.ElementScanner6;

/**
 * @lc app=leetcode.cn id=35 lang=java
 *
 *     [35] 搜索插入位置
 */

// @lc code=start
class Solution {

    /**
     * 二分查找法
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 19.42 % of java submissions (41 MB)
     */
    public int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

// @lc code=end
