import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1838 lang=java
 *
 * [1838] 最高频元素的频数
 */

// @lc code=start
class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 排序 + 滑动窗口
        // return method1(nums, k);

        // 1
        return test(nums, k);
    }

    int test(int[] nums, int k) {
        Arrays.sort(nums);
        long total = 0;
        int left = 0;
        int res = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            total += (long) (nums[i] - nums[i - 1]) * (i - left);
            while (total > k) {
                total -= nums[i] - nums[left];
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    /**
     * Your runtime beats 81.68 % of java submissions
     * Your memory usage beats 33.74 % of java submissions (56.8 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    int method1(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        // 滑动窗口
        for (int r = 1; r < n; r++) {
            // 记录当前数字的总数
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            // 确认窗口期： 执行递减，直到total>k
            while (total > k) {
                total -= nums[r] - nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
// @lc code=end
