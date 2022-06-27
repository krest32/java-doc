/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char tempChar = s.charAt(i);
            int curNbr = getNumber(tempChar);
            if (i >= 1) {
                preNum = getNumber(s.charAt(i - 1));
                /**
                 * 比较当前字符和前一个字符的大小，
                 * 如果[当前]<[之前]，直接累加
                 * 反之减去之前，再累加现在
                 */
                if (preNum >= curNbr) {
                    sum += curNbr;
                } else {
                    sum = sum + curNbr - preNum * 2;
                }
            } else {
                sum = sum + curNbr;
            }
        }
        return sum;
    }

    // 对于追个字母进行解析
    private int getNumber(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
// @lc code=end
