/*
 * @lc app=leetcode.cn id=1903 lang=java
 *
 * [1903] 字符串中的最大奇数
 */

// @lc code=start
class Solution {
    public String largestOddNumber(String num) {
        int j = 0;
        // 排除头部0元素
        if (num.charAt(j) == '0') {
            j++;
        }
        // 从后往前找，如果找到奇数则返回字符串截取的连续最大长度
        for (int i = num.length() - 1; i >= 0; i--) {
            if (getmathod(Integer.parseInt(String.valueOf(num.charAt(i))))) {
                return num.substring(j, i + 1);
            }
        }
        return "";
    }

    public static boolean getmathod(int num) {
        if (num % 2 != 0) {
            return true;
        }
        return false;
    }
}
// @lc code=end
