/*
 * @lc app=leetcode.cn id=2091 lang=java
 *
 * [2091] 从数组中移除最大值和最小值
 */

// @lc code=start
class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int max = 0, min = 0, ans = 0;
        int len = nums.length;
        // 获取最大值、最小值坐标
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
        }

        // 如果max在min的左侧，二者交换位置
        if (max < min) {
            int temp = min;
            min = max;
            max = temp;
        }
        /**
         * 全部从左侧删除，所需要的次数为max+1次
         * 全部从右侧删除，所需要次数为nums.length-min。
         * 从左侧删除min，从右侧删除max需要次数为min+1+nums.length-max。
         * 
         */
        ans = Math.min(max + 1, len - min);
        ans = Math.min(ans, min + 1 + len - max);
        return ans;
    }
}
// @lc code=end
