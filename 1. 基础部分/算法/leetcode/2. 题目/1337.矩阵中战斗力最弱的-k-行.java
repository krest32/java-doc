import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1337 lang=java
 *
 * [1337] 矩阵中战斗力最弱的 K 行
 */

// @lc code=start
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // 模拟
        return extracted(mat, k);
    }

    /**
     * 
     * @param mat
     * @param k
     * @return
     */
    private int[] extracted(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        // 记录每一行的函数以及每一行1的个数
        int[][] all = new int[m][2];
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                cur += mat[i][j];
            }
            all[i] = new int[] { cur, i };
        }
        // 然后针对数组进行排序
        Arrays.sort(all, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = all[i][1];
        return ans;
    }
}
// @lc code=end
