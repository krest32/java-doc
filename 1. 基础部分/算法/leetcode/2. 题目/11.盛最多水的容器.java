/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 双指针
        // return extracted(height);

        // 1
        return onwer1(height);

    }

    private int onwer1(int[] height) {
        int cur = 0;
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            int width = right - left;
            cur = high * width;
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    /**
     * Your runtime beats 67.03 % of java submissions
     * Your memory usage beats 52.24 % of java submissions (51.5 MB)
     */
    private int extracted(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int len = right - left;
            int high = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, high * len);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
// @lc code=end
