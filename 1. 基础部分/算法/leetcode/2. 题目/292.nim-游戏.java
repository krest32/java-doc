
/*
 * @lc app=leetcode.cn id=292 lang=java
 *
 * [292] Nim 游戏
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {

        // 假设共有 n 块石头，如果 n 是
        // 4 的倍数，先手必败；否则先手必胜。
        if (n <= 3)
            return true;
        return !(n % 4 == 0);
    }
}
// @lc code=end
