/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 动态规划
        // return extracted(bookings, n);

        // 1
        return test(bookings, n);
    }

    private int[] test(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    private int[] extracted(int[][] bookings, int n) {
        int[] nums = new int[n];
        // 定义 nums[] 数组记录每站的人数变化，
        // nums[i] 表示第 i+1 站。
        /// 遍历 bookings[]：
        // bookings[i] = [i, j, k] 表示在 i~j 站增加k人 即：counters[i-1] += k，
        // 在 j+1~n 站减少 k 人即 ：counters[j] -= k
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        // 每站的人数为前一站人数加上当前人数变化
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
// @lc code=end
