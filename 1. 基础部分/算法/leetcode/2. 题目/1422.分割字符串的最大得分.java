/*
 * @lc app=leetcode.cn id=1422 lang=java
 *
 * [1422] 分割字符串的最大得分
 */

// @lc code=start

/**
 * 因为分割为两个字符串，所以分割的位置的最左和最右，分别为下标0和1中间 到 n-2和n-1中间。
 * 1、先计算出分割位置在最左边时的max值
 * 2、分隔位置右移，每次移动后，比较得出最大值，直到移动到最右位置
 * 
 */
class Solution {
    public int maxScore(String s) {
        int res = 0, cnt1 = 0, cnt0 = 0; // cnt1统计右边1的个数，同理cnt0左边0的个数
        for (int i = 0; i < s.length(); i++) {
            cnt1 += s.charAt(i) - '0'; // 先统计1的个数
        } // 由于左右区域的数至少为1，所以i不能等于len-1

        for (int i = 0; i < s.length() - 1; i++) { // 点i分为左右两个区域
            if (s.charAt(i) == '0')
                cnt0++; // 遇到01就统计，动态更新左右区域01个数
            else
                cnt1--;
            res = Math.max(res, cnt0 + cnt1);
        }
        return res;
    }
}
// @lc code=end
