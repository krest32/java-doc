import javafx.scene.effect.Light.Point;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int index) {
        int piovt = partitionNum(nums, start, end);
        if (piovt == index) {
            return nums[piovt];
        } else {
            return piovt > index ? quickSelect(nums, start, piovt - 1, index)
                    : quickSelect(nums, piovt + 1, end, index);
        }
    }

    private int partitionNum(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] < pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }
}
// @lc code=end
