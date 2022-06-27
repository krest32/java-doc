/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        // 定义最大空间数组
        int[] p = new int[100000];

        // 将新的信息写入到数组中
        for (int i = 0, j = i; i < len; i++, j++) {
            p[j] = arr[i];
            if (arr[i] == 0) {
                p[j++] = arr[i];
            }
        }
        System.arraycopy(p, 0, arr, 0, len);
    }
}
// @lc code=end
