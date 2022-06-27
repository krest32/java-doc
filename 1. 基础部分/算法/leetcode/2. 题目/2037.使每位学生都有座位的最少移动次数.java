import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2037 lang=java
 *
 * [2037] 使每位学生都有座位的最少移动次数
 */

// @lc code=start
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // 排序，然后求取绝对值和
        return extracted(seats, students);
    }

    /**
     * 262/262 cases passed (2 ms)
     * Your runtime beats 98.6 % of java submissions
     * Your memory usage beats 71.07 % of java submissions (40.9 MB)
     * 
     * @param seats
     * @param students
     * @return
     */
    private int extracted(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int len = seats.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
// @lc code=end
