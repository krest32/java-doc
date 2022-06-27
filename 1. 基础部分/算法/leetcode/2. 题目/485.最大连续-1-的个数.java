/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续 1 的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 一次遍历
        // return extracted(nums);

        // 1
        return test(nums);
    }

    private int test(int[] nums) {
        int len = nums.length;
        int curCnt = 0;
        int maxCnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                curCnt++;
            } else {
                maxCnt = Math.max(maxCnt, curCnt);
                curCnt = 0;
            }
        }
        maxCnt = Math.max(maxCnt, curCnt);

        return maxCnt;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 56.43 % of java submissions (41.8 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
// @lc code=end
