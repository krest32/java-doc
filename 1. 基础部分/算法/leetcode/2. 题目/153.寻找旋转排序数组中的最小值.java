/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        /**
         * 二分查找法
         * 需要先比较比较右侧，然后取到左边界的值
         */
        // return extracted(nums);

        // 暴力法
        return extracted2(nums);
    }

    /**
     * 150/150 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 68.36 % of java submissions (40.9 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.min(ans, nums[i]);
        }
        return ans;
    }

    private int extracted(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
// @lc code=end
