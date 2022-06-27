import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1968 lang=java
 *
 * [1968] 构造元素不等于两相邻元素平均值的数组
 */

// @lc code=start
class Solution {
    public int[] rearrangeArray(int[] nums) {
        return extracted(nums);
    }

    private int[] extracted(int[] nums) {
        int n = nums.length;
        // 为原来的数数组进行排序
        Arrays.sort(nums);
        int[] res = new int[n];
        int idx = 0;
        int left = 0;
        int right = n - 1;
        // 将排序好的数字进行交错相排
        while (left <= right) {
            res[idx++] = nums[left++];
            if (left <= right)
                res[idx++] = nums[right--];
        }
        return res;
    }
}
// @lc code=end
