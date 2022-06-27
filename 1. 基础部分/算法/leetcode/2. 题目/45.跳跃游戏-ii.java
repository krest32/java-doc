/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // 贪心 + 反向
        // return extracted(nums);

        // 贪心 +　正向
        return extracted2(nums);

    }

    /**
     * Your runtime beats 99.12 % of java submissions
     * Your memory usage beats 30.17 % of java submissions (41.7 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        int step = 0;
        int maxLen = 0;
        int len = nums.length;
        int end = 0;
        // 这里又一个边界问题，就是不能够计算到达最后一个点以后的步数
        for (int i = 0; i < len - 1; i++) {
            // 记录每次能够跳的最远的距离
            maxLen = Math.max(maxLen, i + nums[i]);
            if (i == end) {
                end = maxLen;
                step++;
            }
        }
        return step;
    }

    /**
     * Your runtime beats 31.39 % of java submissions
     * Your memory usage beats 15.88 % of java submissions (42 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        while (position > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
}
// @lc code=end
