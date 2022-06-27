import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ListView.EditEvent;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // 矩阵双指针
        // return extracted(A, B);


        // 1
        return test(A, B);

    }

    private int[][] test(int[][] A, int[][] B) {
        List<int[]> ret = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < A.length && idx2 < B.length) {
            int start = Math.max(A[idx1][0], B[idx2][0]);
            int end = Math.min(A[idx1][1], B[idx2][1]);
            // 确定能够构成一个区间
            if (start <= end) {
                ret.add(new int[] { start, end });
            }
            if (A[idx1][1] > B[idx2][1]) {
                idx2++;
            } else {
                idx1++;
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }

    private int[][] extracted(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[] { lo, hi });

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end
