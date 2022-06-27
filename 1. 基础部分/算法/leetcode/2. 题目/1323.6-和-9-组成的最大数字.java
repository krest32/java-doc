/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number(int num) {
        // 模拟
        return extracted(num);
    }

    private int extracted(int num) {
        StringBuffer s = new StringBuffer(Integer.toString(num));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                s.deleteCharAt(i);
                s.insert(i, 9);
                break;
            }
        }
        return Integer.parseInt(s.toString());
    }
}
// @lc code=end
