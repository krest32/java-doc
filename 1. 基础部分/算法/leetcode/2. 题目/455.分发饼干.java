import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 排序+贪心
        Arrays.sort(g);
        Arrays.sort(s);
        int cookies = 0;
        int childs = 0;
        while (cookies < s.length && childs < g.length) {
            if (s[cookies] >= g[childs]) {
                cookies++;
                childs++;
            } else {
                cookies++;
            }
        }
        return childs;
    }
}
// @lc code=end
