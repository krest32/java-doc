import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        // 求数组和
        int sum = Arrays.stream(nums).sum();
        int index = 0;
        // 迭代数组元素
        for (int i = 0; i < nums.length; i++) {
            // 找到中心下标点
            index += nums[i];
            if (sum == index) {
                return i;
            } else {
                sum = sum - nums[i];
            }
        }
        return -1;
    }
}
// @lc code=end
