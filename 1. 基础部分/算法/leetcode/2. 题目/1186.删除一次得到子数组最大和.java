/*
 * @lc app=leetcode.cn id=1186 lang=java
 *
 * [1186] 删除一次得到子数组最大和
 */

// @lc code=start
class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        // dp1 一个表示不删除元素的情况下最大子数组和，
        // dp2 代表删除元素的情况下的最大子数组和
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int res = arr[0];
        dp1[0] = arr[0];
        // 保证dp2[1]存储的是dp1[0]
        dp2[0] = -100000;
        for (int i = 1; i < n; i++) {
            // 记录当前数组每个位置的最大的累加值
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
            // 记录减掉当前数字以后的最大值
            dp2[i] = Math.max(dp2[i - 1] + arr[i], dp1[i - 1]);
            res = Math.max(res, Math.max(dp1[i], dp2[i]));
        }
        return res;
    }
}
// @lc code=end
