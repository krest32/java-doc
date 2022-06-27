/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // 模拟 --> 寻找一个递增的顶点即可
        return extracted(arr);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 45.48 % of java submissions (41.4 MB)
     * 
     * @param arr
     * @return
     */
    private int extracted(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i) {
            // 找到第一次递增的下标值
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
// @lc code=end
