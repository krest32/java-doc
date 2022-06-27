/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 使用二分查找法，利用到了局部有序的条件
        return extracted(matrix, k);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 20.76 % of java submissions (47 MB)
     * 
     * @param matrix
     * @param k
     * @return
     */
    private int extracted(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 找到他们的中间数字，
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                // 直到找到第一个小于k的数字的位置
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            // 先拿每一行最右侧的元素与目标数字进行对比
            if (matrix[i][j] <= mid) {
                // 然后获取得到相应的位置
                num = num + i + 1;
                j++;
            } else {
                i--;
            }
        }
        // 计算左上角区域有多少小于等于mid的数字
        return num >= k;
    }
}
// @lc code=end
