/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {

    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public String intToRoman(int num) {
        // 模拟
        // return extracted(num);

        return onwer1(num);

    }

    private String onwer1(int num) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String temp = symbols[i];
            while (num >= value) {
                num -= value;
                ret.append(temp);
            }
            if (num == 0) {
                break;
            }
        }

        return ret.toString();
    }

    /**
     * Your runtime beats 96.27 % of java submissions
     * Your memory usage beats 38.78 % of java submissions (40.9 MB)
     * 
     * @param num
     * @return
     */
    private String extracted(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
// @lc code=end
