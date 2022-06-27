import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] nums) {
        // 贪心 + 排序
        return extracted(nums);
    }

    /**
     * Your runtime beats 99.77 % of java submissions
     * Your memory usage beats 39.14 % of java submissions (41.6 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] - nums[i - 1] < nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
// @lc code=end
