import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498]  
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // 使用队列 --> 复杂且效率低下
        // return extracted(mat);

        // 一次遍历
        return extracted2(mat);

    }

    /**
     * Your runtime beats 81.67 % of java submissions
     * Your memory usage beats 45.4 % of java submissions (43 MB)
     * 
     * @param mat
     * @return
     */
    private int[] extracted2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, id = 0;
        for (int iter = 0; iter < m + n - 1; iter++) {
            // 用來切換方向
            if ((iter & 1) == 0) {
                while (i >= 0 && j < n) {
                    res[id++] = mat[i][j];
                    j++;
                    i--;
                }
                if (j < n) {
                    i++;
                } else {
                    i += 2;
                    j--;
                }
            } else {
                while (i < m && j >= 0) {
                    res[id++] = mat[i][j];
                    i++;
                    j--;
                }
                if (i < m) {
                    j++;
                } else {
                    j += 2;
                    i--;
                }
            }
        }
        return res;
    }

    /**
     * Your runtime beats 8.03 % of java submissions
     * Your memory usage beats 13.47 % of java submissions (43.4 MB)
     * 
     * @param mat
     * @return
     */
    private int[] extracted(int[][] mat) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int t = 0;
        queue.offer(0);
        int flag = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while (size > 0) {
                int num = queue.poll();
                int x = num / 10001;
                int y = num % 10001;
                temp.add(mat[x][y]);
                if (y < n - 1)
                    queue.offer(x * 10001 + y + 1);
                if (x < m - 1 && y == 0)
                    queue.offer((x + 1) * 10001 + y);
                size--;
            }
            if (flag == 1) {
                Collections.reverse(temp);
            }
            res.addAll(temp);
            flag = -flag;
        }
        for (int x : res) {
            ans[t++] = x;
        }
        return ans;
    }
}
// @lc code=end
