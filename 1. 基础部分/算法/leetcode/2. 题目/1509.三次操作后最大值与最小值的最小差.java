import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1509 lang=java
 *
 * [1509] 三次操作后最大值与最小值的最小差
 */

// @lc code=start
class Solution {
    public int minDifference(int[] nums) {
        // 数学推导
        // return extracted(nums);

        // 1
        return test(nums);
    }

    private int test(int[] nums) {
        int len = nums.length;
        if (len <= 4)
            return 0;
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++)
            ret = Math.min(ret, nums[len - 4 + i] - nums[i]);
        return ret;
    }

    /**
     * 59/59 cases passed (16 ms)
     * Your runtime beats 89.76 % of java submissions
     * Your memory usage beats 31.5 % of java submissions (54.7 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int len = nums.length;
        if (len <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        // 优先改变最大值 == 最小值
        // 所以分别比较是三个位置的最大值和最小值的差值即可
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, nums[len - 4 + i] - nums[i]);
        }
        return ret;
    }
}
// @lc code=end
