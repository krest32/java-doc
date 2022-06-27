import static org.junit.jupiter.api.Assertions.assertAll;

/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            // 记录每个极点连续递增的个数
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }

        int[] right = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            // 记录每个节点连续递减的个数
            right[i] = arr[i + 1] < arr[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] > 0 && right[i] > 0) {
                // 比较连续递减的个数，然后获取最大值+1
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
// @lc code=end
