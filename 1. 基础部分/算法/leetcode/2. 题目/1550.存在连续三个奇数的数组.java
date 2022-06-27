/*
 * @lc app=leetcode.cn id=1550 lang=java
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // 模拟
        return extracted(arr);
    }

    /**
     * 32/32 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 6.59 % of java submissions (41.1 MB)
     * 
     * @param arr
     * @return
     */
    private boolean extracted(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            if (i + 2 < len) {
                if (arr[i] % 2 == 1
                        && arr[i + 1] % 2 == 1
                        && arr[i + 2] % 2 == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
