/*
 * @lc app=leetcode.cn id=1812 lang=java
 *
 * [1812] 判断国际象棋棋盘中一个格子的颜色
 */

// @lc code=start
class Solution {
    public boolean squareIsWhite(String coordinates) {
        // 进行奇数和偶数的判断
        return extracted(coordinates);

    }

    /**
     * 203/203 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 56.89 % of java submissions (39.3 MB)
     * 
     * @param coordinates
     * @return
     */
    private boolean extracted(String coordinates) {
        // + 1 是为了将坐标映射成 [1, n]，而不是 [0, n - 1]
        int x = coordinates.charAt(0) - 'a' + 1;
        int y = coordinates.charAt(1) - '0';
        // 根据行和列的奇偶性来判断返回值
        return (x & 1) == 1 ? (y & 1) == 1
                ? false
                : true : (y & 1) == 0 ? false : true;
    }
}
// @lc code=end
