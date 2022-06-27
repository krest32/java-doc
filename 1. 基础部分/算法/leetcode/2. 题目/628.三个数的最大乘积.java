import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 */

// @lc code=start
class Solution {
    public int maximumProduct(int[] nums) {
        // 线性扫描 --> 最优解
        return extracted(nums);

        // 排序
        // return extracted2(nums);

    }

    /**
     * Your runtime beats 69.03 % of java submissions
     * Your memory usage beats 23.02 % of java submissions (42.6 MB)
     * 
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1],
                nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    private int extracted(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 获取两个最小负数
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }

            // 获取三个最大正数
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
        }
        return Math.max(min2 * min1 * max1, max1 * max2 * max3);
    }
}
// @lc code=end
