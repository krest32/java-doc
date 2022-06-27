/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {

    public int longestSubarray(int[] nums) {
        // 模拟递推公式
        // return method1(nums);

        // 1
        return test(nums);
    }

    int test(int[] nums) {
        int len = nums.length;
        int a = 0;
        int b = 0;
        int ret = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                a++;
                b++;
                ret = Math.max(ret, a);
            } else {
                a = b;
                b = 0;
            }
        }

        if (ret == len) {
            ret--;
        }
        return ret;
    }

    /**
     * Your runtime beats 86.17 % of java submissions
     * Your memory usage beats 36.31 % of java submissions (49.6 MB)
     * 
     * @param nums
     * @return
     */
    int method1(int[] nums) {
        int ret = 0;
        int a = 0;
        int b = 0;
        int len = nums.length;
        // a 存中间有一个“非1”的和，
        // b 存连续1的和，遇 1 两数自增，
        // 遇“非1” a=b;b=0。
        // 扫描过程保存最大的 a 值，最后处理一下全1特例即可。
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                a++;
                b++;
                ret = Math.max(ret, a);
            } else {
                a = b;
                b = 0;
            }
        }
        if (ret == len) {
            ret--;
        }
        return ret;
    }
}
// @lc code=end
