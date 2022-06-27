/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    /**
     * 位运算
     * 
     * @param num
     * @return
     */
    public int addDigits(int num) {
        // 位运算
        return (num - 1) % 9 + 1;

        // 模拟题意
        // return extracted(num);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 18.93 % of java submissions (38.9 MB)
     * 
     * @param num
     * @return
     */
    private int extracted(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
// @lc code=end
