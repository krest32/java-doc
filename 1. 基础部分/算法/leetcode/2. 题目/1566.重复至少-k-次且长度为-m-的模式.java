
/*
 * @lc app=leetcode.cn id=1566 lang=java
 *
 * [1566] 重复至少 K 次且长度为 M 的模式
 */

// @lc code=start
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        // 模拟
        return extracted(arr, m, k);
    }

    /**
     * 93/93 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 67.78 % of java submissions (38.9 MB)
     * 
     * @param arr
     * @param m
     * @param k
     * @return
     */
    private boolean extracted(int[] arr, int m, int k) {
        int n = arr.length;
        for (int l = 0; l <= n - m * k; ++l) {
            int offset;
            for (offset = 0; offset < m * k; ++offset) {
                if (arr[l + offset] != arr[l + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
