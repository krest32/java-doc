import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 模拟
        // return extracted(nums);

        // 双指针    
        return method(nums);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 26.48 % of java submissions (43.2 MB)
     * 
     * @param nums
     * @return
     */
    int[] method(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    /**
     * Your runtime beats 26.26 % of java submissions
     * Your memory usage beats 29.93 % of java submissions (43.1 MB)
     * 
     * @param nums
     * @return
     */
    private int[] extracted(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
// @lc code=end
