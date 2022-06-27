import javafx.beans.binding.StringBinding;

/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        // 模拟
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        while (l1 >= 0 || l2 >= 0) {
            int x = l1 < 0 ? 0 : num1.charAt(l1) - '0';
            int y = l2 < 0 ? 0 : num2.charAt(l2) - '0';
            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;
            l1--;
            l2--;
        }
        if (carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }
}
// @lc code=end
