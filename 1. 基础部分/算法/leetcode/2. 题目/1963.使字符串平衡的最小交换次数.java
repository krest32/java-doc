/*
 * @lc app=leetcode.cn id=1963 lang=java
 *
 * [1963] 使字符串平衡的最小交换次数
 */

// @lc code=start
class Solution {
    public int minSwaps(String s) {
        /**
         * 贪心
         * 1.括号匹配时，cnt是左括号数量-右括号数量
         * 2.当 cnt<0 时，就说明要调整一次了
         * 3.每调整一次，cnt就增加2
         */
        return extracted(s);
    }

    /**
     * 58/58 cases passed (20 ms)
     * Your runtime beats 28.28 % of java submissions
     * Your memory usage beats 14.48 % of java submissions (50 MB)
     */
    private int extracted(String s) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[')
                cnt++;
            else
                cnt--;

            if (cnt < 0) {
                res++;
                cnt += 2;
            }
        }

        return res;
    }
}
// @lc code=end
