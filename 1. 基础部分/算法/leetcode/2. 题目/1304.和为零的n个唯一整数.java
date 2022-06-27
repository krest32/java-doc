/*
 * @lc app=leetcode.cn id=1304 lang=java
 *
 * [1304] 和为零的N个唯一整数
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        // 模拟 : 如果个数为奇数，责加上0，如果为偶数，则去掉0
        return extracted(n);
    }

    private int[] extracted(int n) {
        int[] nums = new int[n];

        if (n == 1) {
            nums[0] = 0;
            return nums;
        }
        if (n % 2 != 0) {
            for (int i = 0, k = 1; i < n - 1; i += 2, ++k) {
                nums[i] = k;
                nums[i + 1] = -k;
            }
            nums[n - 1] = 0;
        } else {
            for (int i = 0, k = 1; i < n - 1; i += 2, ++k) {
                nums[i] = k;
                nums[i + 1] = -k;
            }
        }
        return nums;
    }
}
// @lc code=end
