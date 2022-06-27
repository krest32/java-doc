/*
 * @lc app=leetcode.cn id=1946 lang=java
 *
 * [1946] 子字符串突变后可能得到的最大整数
 */

// @lc code=start
class Solution {
    public String maximumNumber(String num, int[] change) {
        boolean flag = false;
        char[] chArr = num.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            int temp = chArr[i] - '0';
            if (flag && temp > change[temp]) {
                break;
            }
            if (temp < change[temp]) {
                chArr[i] = (char) ('0' + change[temp]);
                flag = true;
            }
        }
        return new String(chArr);
    }
}
// @lc code=end
