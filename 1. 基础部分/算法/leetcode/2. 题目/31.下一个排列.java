/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        // 模拟
        extracted(nums);
    }

    /**
     * 
     * 以排列 [4,5,2,6,3,1] 为例：
     * 我们能找到的符合条件的一对「较小数」与「较大数」的组合为 2 与 3，
     * 满足「较小数」尽量靠右，而「较大数」尽可能小。
     * 
     * 当我们完成交换后排列变为 [4,5,3,6,2,1]，
     * 此时我们可以重排「较小数」右边的序列，序列变为[4,5,3,1,2,6]。
     * 
     * @param nums
     */
    private void extracted(int[] nums) {
        int i = nums.length - 2;
        // 先找到第一个递减的点
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // 再找到第一个递减的节点
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
// @lc code=end
