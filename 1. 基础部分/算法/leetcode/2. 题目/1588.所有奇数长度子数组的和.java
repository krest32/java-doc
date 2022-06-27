/*
 * @lc app=leetcode.cn id=1588 lang=java
 *
 * [1588] 所有奇数长度子数组的和
 */

// @lc code=start
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // 暴力求和
        // return extracted(arr);

        // 1
        return test(arr);
    }

    /**
     * Your runtime beats 42.83 % of java submissions
     * Your memory usage beats 49.73 % of java submissions (39 MB)
     * 
     * @param arr
     * @return
     */
    private int test(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; i + j <= len; j += 2) {
                int k = i + j - 1;
                for (int m = i; m <= k; m++) {
                    sum += arr[m];
                }
            }
        }
        return sum;
    }

    private int extracted(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; i + j <= len; j += 2) {
                int k = i + j - 1;
                for (int m = i; m <= k; m++) {
                    sum += arr[m];
                }
            }
        }
        return sum;
    }
}
// @lc code=end
