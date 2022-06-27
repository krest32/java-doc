/*
 * @lc app=leetcode.cn id=1503 lang=java
 *
 * [1503] 所有蚂蚁掉下来前的最后一刻
 */

// @lc code=start
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for (int ant : left) {
            lastMoment = Math.max(lastMoment, ant);
        }
        for (int ant : right) {
            lastMoment = Math.max(lastMoment, n - ant);
        }
        return lastMoment;
    }
}
// @lc code=end
