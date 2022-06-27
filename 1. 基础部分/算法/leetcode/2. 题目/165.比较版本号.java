import java.time.format.TextStyle;

/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        // 模拟
        // return method1(version1, version2);

        // 1
        return test(version1, version2);
    }

    int test(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();

        int idx1 = 0, idx2 = 0;
        while (idx1 < len1 || idx2 < len2) {
            int x = 0;
            for (; idx1 < len1 && version1.charAt(idx1) != '.'; idx1++) {
                x = x * 10 + version1.charAt(idx1) - '0';
            }
            idx1++;
            int y = 0;
            for (; idx2 < len2 && version2.charAt(idx2) != '.'; idx2++) {
                y = y * 10 + version2.charAt(idx2) - '0';
            }
            idx2++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 26.08 % of java submissions (39.5 MB)
     * 
     * @param version1
     * @param version2
     * @return
     */
    int method12(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            i++; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            j++; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
// @lc code=end
