import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        // 解法一： 齐行双指针
        // return extracted1(nums, val)

        // 解法二： 首尾双指针 （优化解法一）
        return extracted2(nums, val);
    }

    /**
     * 
     * 首尾双指针
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 36.4 % of java submissions (39.8 MB)
     * 
     * @param nums
     * @param val
     * @return
     */
    private int extracted2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     * 齐行双指针
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 10.12 % of java submissions (40.1 MB)
     * 
     * @param nums
     * @param val
     * @return
     */
    private int extracted1(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            /**
             * j 代表了 不等于 val 的值的下标
             */
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
// @lc code=end
