/*
 * @lc app=leetcode.cn id=1360 lang=java
 *
 * [1360] 日期之间隔几天
 */

// @lc code=start
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] temp = dateStr.split("-");
        int year = Integer.valueOf(temp[0]);
        int month = Integer.valueOf(temp[1]);
        int day = Integer.valueOf(temp[2]);

        if (month <= 2) {
            year--;
            month += 10;
        } else
            month -= 2;
        return 365 * year + year / 4 - year / 100 + year / 400 + 30 * month + (3 * month - 1) / 5 + day - 584418;

    }
}
// @lc code=end
