/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {

    /**
     * 模拟
     *  
     * 从后向前，同为1，则为0， 同为0 则为0， 1、0 则为 1
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        // 初始化揭露结果的变量
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        // 从后向前遍历两个String
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            // 判断 i, j 都大于0时，从String中进行取值
            sum = sum + (i >= 0 ? a.charAt(i) - '0' : 0);
            sum = sum + (j >= 0 ? b.charAt(j) - '0' : 0);
            // 追加 计算 结果
            ans.append(sum % 2);
            carry = sum / 2;
        }

        // 判断Carry是否有值
        ans.append(carry == 1 ? carry : "");
        return ans.reverse().toString();
    }
}
// @lc code=end
