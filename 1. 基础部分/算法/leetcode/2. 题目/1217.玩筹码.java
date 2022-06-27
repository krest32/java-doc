/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] position) {
        // 位运算
        int count1 = 0;
        for (int i : position)
            count1 += i & 1; // 奇数个数
        int count0 = position.length - count1; // 偶数个数
        return count0 > count1 ? count1 : count0;
    }
}
// @lc code=end
