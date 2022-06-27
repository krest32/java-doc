import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            // i%2 判断i是否为偶数，如果是偶数，如果不是偶数就加上后半部分
            nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
        }

        return Arrays.stream(nums).max().getAsInt();
    }
}
// @lc code=end
