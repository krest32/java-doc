/*
 * @lc app=leetcode.cn id=1641 lang=java
 *
 * [1641] 统计字典序元音字符串的数目
 */

// @lc code=start
class Solution {
    public int countVowelStrings(int n) {
        /**
         * 列出之后，发现是杨辉三角的计算规则
         * a = a;
         * b = a + b;
         * c = a + b + c;
         * d = a + b + c + d;
         * e = a + b + c + d + e;
         * 代码中简写了，很简洁。
         * 
         */
        int a = 1, b = 1, c = 1, d = 1, e = 1;
        for (int i = 0; i < n; i++) {
            b += a;
            c += b;
            d += c;
            e += d;
        }
        return e;
    }
}
// @lc code=end
