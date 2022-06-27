
/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    /**
     * 反向遍历
     * 
     * @param digits 请求数组
     * @return
     */
    public int[] plusOne(int[] digits) {
        // 从后向前进行遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果当前值不为9，那么累加并返回
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // 当数组中都为9时，对数组扩容
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
// @lc code=end
