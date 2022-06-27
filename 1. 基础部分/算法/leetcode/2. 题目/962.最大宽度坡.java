import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=962 lang=java
 *
 * [962] 最大宽度坡
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        // 排序
        // return extracted(nums);

        // 暴力 时间上与前者差异较大
        return extracted2(nums);

    }

    /**
     * 98/98 cases passed (1435 ms)
     * Your runtime beats 9.63 % of java submissions
     * Your memory usage beats 81.57 % of java submissions (48.5 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        int ans = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (j - i <= ans)
                    break;
                if (nums[j] >= nums[i]) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    /**
     * 98/98 cases passed (41 ms)
     * Your runtime beats 35.2 % of java submissions
     * Your memory usage beats 44.83 % of java submissions (48.8 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int len = nums.length;
        // 记录每个数字的最终下标
        Integer[] B = new Integer[len];
        for (int i = 0; i < len; ++i)
            B[i] = i;
        // 然后对 B 进行排序
        Arrays.sort(B, (i, j) -> ((Integer) nums[i]).compareTo(nums[j]));

        int ans = 0;
        int m = len;
        for (int i : B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }
        return ans;
    }
}
// @lc code=end
