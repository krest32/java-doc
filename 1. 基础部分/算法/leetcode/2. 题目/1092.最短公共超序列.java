

/*
 * @lc app=leetcode.cn id=1092 lang=java
 *
 * [1092] 最短公共超序列
 */

// @lc code=start
class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {

        if (str1.indexOf(str2) >= 0) {
            return str1;
        }

        StringBuilder res1 = buildStr(str1, str2);
        StringBuilder res2 = buildStr(str2, str1);
        System.out.println(res1);
        System.out.println(res2);
        return res1.length() <= res2.length() ? res1.toString() : res2.toString();

    }

    private StringBuilder buildStr(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int idx1 = 0;
        int idx2 = 0;
        StringBuilder res = new StringBuilder();
        while (idx1 < len1 || idx2 < len2) {
            char ch;
            if (idx2 >= len2 && idx1 < len1) {
                ch = str1.charAt(idx1++);
            } else if (idx1 >= len1 && idx2 < len2) {
                ch = str2.charAt(idx2++);
            } else {
                if (str1.charAt(idx1) == str2.charAt(idx2)) {
                    ch = str1.charAt(idx1);
                    idx1++;
                    idx2++;
                } else {
                    ch = str2.charAt(idx2);
                    idx2++;
                }
            }
            res.append(ch);
        }
        return res;
    }
}
// @lc code=end
