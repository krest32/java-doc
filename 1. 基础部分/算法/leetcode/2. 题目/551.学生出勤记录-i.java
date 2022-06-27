/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        // 模拟 一次遍历
        return extracted(s);
    }

    private boolean extracted(String s) {
        int absents = 0, lates = 0;
        int n = s.length();
        // 直接判断缺勤的次数，或者连续三天及以上的迟到
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absents++;
                if (absents >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                lates++;
                if (lates >= 3) {
                    return false;
                }

            } else {
                lates = 0;
            }
        }
        return true;
    }
}
// @lc code=end
