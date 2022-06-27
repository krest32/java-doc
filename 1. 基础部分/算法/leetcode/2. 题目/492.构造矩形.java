/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        // 数学
        for (int i = (int) (Math.sqrt(area));; i--) {
            if (area % i == 0)
                return new int[] { area / i, i };
        }
    }
}
// @lc code=end
